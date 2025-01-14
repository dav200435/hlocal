package inteligencia_artificial;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


//TODO Estructurar codigo
class Nodo {
	double latitud, longitud;
	double g, h, f;
	Nodo padre;
	ArrayList<Nodo> vecinos;
	String nombre;

	public Nodo(String nombre, double latitud, double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
		this.g = 0;
		this.h = 0;
		this.f = 0;
		this.padre = null;
		this.vecinos = new ArrayList<>();
		this.nombre = nombre;
	}

	// Comparar nodos para la cola de prioridad
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Nodo) {
			Nodo otro = (Nodo) obj;
			return this.latitud == otro.latitud && this.longitud == otro.longitud;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(latitud, longitud);
	}

}

public class Metro implements ActionListener {
	private static JLabel label;
	private static JComboBox<String> inicioBox;
	private static JLabel label1;
	private static JComboBox<String> DestinoBox;
	private static JButton boton;
	private static JTextArea res;
	private static CustomPanel panel;
	public static double distanciaTotal = 0;
	private static HashMap<String, Nodo> mapaS = new HashMap<>();
	private static LinkedList<Nodo> camino;

	public static double heuristica(Nodo ini, Nodo fin) {
		// Radio de la Tierra en kilómetros
		final double R = 6371.0;

		// Convertir latitudes y longitudes de grados a radianes
		double lat1Rad = Math.toRadians(ini.latitud);
		double long1Rad = Math.toRadians(ini.longitud);
		double lat2Rad = Math.toRadians(fin.latitud);
		double long2Rad = Math.toRadians(fin.longitud);

		// Calcular las diferencias de latitud y longitud
		double deltaLat = lat2Rad - lat1Rad;
		double deltaLong = long2Rad - long1Rad;

		// Aplicar la fórmula de Haversine
		double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
				+ Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.sin(deltaLong / 2) * Math.sin(deltaLong / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		// Calcular la distancia
		double distancia = R * c;

		return distancia;
	}

	public static LinkedList<Nodo> a_estrella(Nodo inicio, Nodo fin) {
		ArrayList<Nodo> listaCerrada = new ArrayList<>();
		LinkedList<Nodo> res = new LinkedList<>();
		PriorityQueue<Nodo> listaAbierta = new PriorityQueue<>(
				Comparator.comparingDouble((Nodo nodo) -> nodo.f).thenComparingDouble(nodo -> nodo.h));

		Map<String, Double> transbordos = new HashMap<>();
		transbordos.put("Lima-Avenida de Mayo", 0.450);
		transbordos.put("Avenida de Mayo-Lima", 0.450);
		transbordos.put("Perú-Bolívar", 0.300);
		transbordos.put("Bolívar-Perú", 0.300);
		transbordos.put("Perú-Catedral", 0.220);
		transbordos.put("Catedral-Perú", 0.220);
		transbordos.put("Bolívar-Catedral", 0.500);
		transbordos.put("Catedral-Bolívar", 0.500);
		transbordos.put("Independencia-Independencia", 0.210);
		transbordos.put("Carlos Pellegrini-9 de Julio", 0.150);
		transbordos.put("9 de Julio-Diagonal Norte", 0.070);

		listaAbierta.add(inicio);
		inicio.f = 0;
		while (!listaAbierta.isEmpty()) {
			Nodo actual = listaAbierta.poll();
			listaCerrada.add(actual);

			if (actual.equals(fin)) {
				while (!actual.equals(inicio)) {
					res.addFirst(actual);
					actual = actual.padre;
				}
				res.addFirst(inicio);
				break;
			}

			for (Nodo vecino : actual.vecinos) {
				if (listaCerrada.contains(vecino)) {
					continue;
				}

				double nuevoG = actual.g + heuristica(actual, vecino);

				// Verificar si hay un costo de transbordo
				String clave1 = actual.nombre + "-" + vecino.nombre;
				String clave2 = vecino.nombre + "-" + actual.nombre;

				if (transbordos.containsKey(clave1)) {
					nuevoG += transbordos.get(clave1);
				} else if (transbordos.containsKey(clave2)) {
					nuevoG += transbordos.get(clave2);
				}

				if (listaAbierta.contains(vecino)) {
					if (vecino.g > nuevoG) {
						vecino.g = nuevoG;
						vecino.f = vecino.g + vecino.h;
						vecino.padre = actual;
					}
				} else {
					vecino.g = nuevoG;
					vecino.h = heuristica(vecino, fin);
					vecino.f = vecino.g + vecino.h;
					vecino.padre = actual;
					listaAbierta.add(vecino);
				}
			}
		}
		distanciaTotal = fin.g;
		return res;
	}

	public static void GUI() {
		JFrame frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.black);
		panel = new CustomPanel();
		panel.setLayout(null);
		panel.setBackground(Color.lightGray);
		frame.add(panel);

		label = new JLabel("ESTACIÓN ORIGEN");
		label.setBounds(68, 70, 200, 25);
		label.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		label.setForeground(Color.white);
		panel.add(label);

		String[] opciones = { "9 de Julio", "Alberti", "Avenida de Mayo", "Belgrano", "Bolívar", "Callao Línea B",
				"Callao Línea D", "Carlos Pellegrini", "Catedral", "Congreso", "Constitución", "Diagonal Norte",
				"Entre Ríos", "Facultad de Medicina", "Florida", "General San Martín", "Independencia Línea C",
				"Independencia Línea E", "Lima", "Lavalle", "Leandro N. Alem", "Moreno", "Pasco", "Pasteur", "Perú",
				"Pichincha", "Piedras", "Plaza de Mayo", "Retiro", "San Juan", "San José", "Sáenz Peña", "Tribunales",
				"Uruguay" };

		inicioBox = new JComboBox<>(opciones);
		inicioBox.setBounds(68, 100, 379, 25);
		inicioBox.setFont(new Font("Arial", Font.BOLD, 18));
		inicioBox.setSelectedIndex(-1);
		panel.add(inicioBox);

		label1 = new JLabel("ESTACIÓN DESTINO");
		label1.setBounds(68, 150, 200, 25);
		label1.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		label1.setForeground(Color.white);
		panel.add(label1);

		DestinoBox = new JComboBox<>(opciones);
		DestinoBox.setBounds(68, 180, 379, 25);
		DestinoBox.setFont(new Font("Arial", Font.BOLD, 18));
		DestinoBox.setSelectedIndex(-1);
		panel.add(DestinoBox);

		boton = new JButton("BUSCAR RUTA MÁS CORTA");
		boton.setBounds(68, 240, 379, 40);
		boton.addActionListener(new Metro());
		boton.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(boton);

		res = new JTextArea();
		res.setBounds(50, 300, 415, 700);
		res.setLineWrap(true);
		res.setWrapStyleWord(true);
		res.setEditable(false);
		res.setBackground(Color.GRAY);
		res.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		res.setForeground(Color.WHITE);
		panel.add(res);

		Image img1 = new ImageIcon("UPM.png").getImage();
		Image img2 = new ImageIcon("cuadricula.png").getImage();
		Image scaledImg1 = img1.getScaledInstance(img1.getWidth(res), img1.getHeight(res), Image.SCALE_REPLICATE);
		Image scaledImg2 = img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		panel.setImage(scaledImg1, scaledImg2);

		JLabel LineaA = new JLabel("Alberti - Plaza de Mayo");
		LineaA.setBounds(1300, 550, 140, 25);
		LineaA.setForeground(Color.WHITE);
		panel.add(LineaA);
		JLabel LineaB1 = new JLabel("Pasteur -");
		JLabel LineaB2 = new JLabel("Leandro N. Alem");
		LineaB1.setBounds(1300, 600, 140, 25);
		LineaB2.setBounds(1354, 600, 140, 25);
		LineaB1.setForeground(Color.WHITE);
		LineaB2.setForeground(Color.WHITE);
		panel.add(LineaB1);
		panel.add(LineaB2);
		JLabel LineaC = new JLabel("Retiro - Constitución");
		LineaC.setBounds(1300, 650, 140, 25);
		LineaC.setForeground(Color.WHITE);
		panel.add(LineaC);
		JLabel LineaD1 = new JLabel("Facultad de Medicina -");
		JLabel LineaD2 = new JLabel("Catedral");
		LineaD1.setBounds(1300, 700, 140, 25);
		LineaD2.setBounds(1430, 700, 140, 25);
		LineaD1.setForeground(Color.WHITE);
		LineaD2.setForeground(Color.WHITE);
		panel.add(LineaD1);
		panel.add(LineaD2);
		JLabel LineaE = new JLabel("Pichincha - Bolívar");
		LineaE.setBounds(1300, 750, 140, 25);
		LineaE.setForeground(Color.WHITE);
		panel.add(LineaE);

		JLabel Facultad_de_Medicina = new JLabel("Facultad de Medicina");
		Facultad_de_Medicina.setBounds(550, 123, 140, 25);
		panel.add(Facultad_de_Medicina);
		JLabel CallaoD = new JLabel("Callao");
		CallaoD.setBounds(737, 123, 140, 25);
		panel.add(CallaoD);
		JLabel Tribunales = new JLabel("Tribunales");
		Tribunales.setBounds(855, 172, 140, 25);
		panel.add(Tribunales);
		JLabel Nueve_de_Julio = new JLabel("9 de Julio");
		Nueve_de_Julio.setBounds(930, 263, 140, 25);
		panel.add(Nueve_de_Julio);
		JLabel Catedral = new JLabel("Catedral");
		Catedral.setBounds(1133, 304, 140, 25);
		panel.add(Catedral);
		JLabel Pasteur = new JLabel("Pasteur");
		Pasteur.setBounds(600, 253, 140, 25);
		panel.add(Pasteur);
		JLabel CallaoB = new JLabel("Callao");
		CallaoB.setBounds(733, 253, 140, 25);
		panel.add(CallaoB);
		JLabel Uruguay = new JLabel("Uruguay");
		Uruguay.setBounds(815, 253, 140, 25);
		panel.add(Uruguay);
		JLabel Carlos_Pellegrini = new JLabel("Carlos Pellegrini");
		Carlos_Pellegrini.setBounds(951, 211, 140, 25);
		panel.add(Carlos_Pellegrini);
		JLabel Florida = new JLabel("Florida");
		Florida.setBounds(1110, 253, 140, 25);
		panel.add(Florida);
		JLabel Leandro = new JLabel("Leandro N. Alem");
		Leandro.setBounds(1185, 253, 140, 25);
		panel.add(Leandro);
		JLabel Alberti = new JLabel("Alberti");
		Alberti.setBounds(553, 378, 140, 25);
		panel.add(Alberti);
		JLabel Pasco = new JLabel("Pasco");
		Pasco.setBounds(640, 378, 140, 25);
		panel.add(Pasco);
		JLabel Congreso = new JLabel("Congreso");
		Congreso.setBounds(720, 378, 140, 25);
		panel.add(Congreso);
		JLabel Saenz_Peña = new JLabel("Sáenz Peña");
		Saenz_Peña.setBounds(805, 378, 140, 25);
		panel.add(Saenz_Peña);
		JLabel Lima = new JLabel("Lima");
		Lima.setBounds(905, 378, 140, 25);
		panel.add(Lima);
		JLabel Piedras = new JLabel("Piedras");
		Piedras.setBounds(1031, 378, 140, 25);
		panel.add(Piedras);
		JLabel Peru = new JLabel("Perú");
		Peru.setBounds(1100, 378, 140, 25);
		panel.add(Peru);
		JLabel Plaza_de_Mayo = new JLabel("Plaza de Mayo");
		Plaza_de_Mayo.setBounds(1172, 335, 140, 25);
		panel.add(Plaza_de_Mayo);
		JLabel Pichincha = new JLabel("Pichincha");
		Pichincha.setBounds(589, 653, 140, 25);
		panel.add(Pichincha);
		JLabel Entre_Rios = new JLabel("Entre Ríos");
		Entre_Rios.setBounds(718, 653, 140, 25);
		panel.add(Entre_Rios);
		JLabel San_Jose = new JLabel("San José");
		San_Jose.setBounds(811, 653, 140, 25);
		panel.add(San_Jose);
		JLabel IndependenciaE = new JLabel("Independencia");
		IndependenciaE.setBounds(788, 540, 140, 25);
		panel.add(IndependenciaE);
		JLabel Belgrano = new JLabel("Belgrano");
		Belgrano.setBounds(1014, 478, 140, 25);
		panel.add(Belgrano);
		JLabel Bolivar = new JLabel("Bolívar");
		Bolivar.setBounds(1132, 412, 140, 25);
		panel.add(Bolivar);
		JLabel Retiro = new JLabel("Retiro");
		Retiro.setBounds(1225, 75, 140, 25);
		panel.add(Retiro);
		JLabel General_San_Martin = new JLabel("General San Martín");
		General_San_Martin.setBounds(1140, 130, 140, 25);
		panel.add(General_San_Martin);
		JLabel Lavalle = new JLabel("Lavalle");
		Lavalle.setBounds(1087, 205, 140, 25);
		panel.add(Lavalle);
		JLabel Diagonal_Norte = new JLabel("Diagonal Norte");
		Diagonal_Norte.setBounds(980, 300, 140, 25);
		panel.add(Diagonal_Norte);
		JLabel Avenida_de_Mayo = new JLabel("Avenida de Mayo");
		Avenida_de_Mayo.setBounds(867, 334, 140, 25);
		panel.add(Avenida_de_Mayo);
		JLabel Moreno = new JLabel("Moreno");
		Moreno.setBounds(915, 416, 140, 25);
		panel.add(Moreno);
		JLabel IndependenciaC = new JLabel("Independencia");
		IndependenciaC.setBounds(990, 540, 140, 25);
		panel.add(IndependenciaC);
		JLabel San_Juan = new JLabel("San Juan");
		San_Juan.setBounds(990, 631, 140, 25);
		panel.add(San_Juan);
		JLabel Constiticion = new JLabel("Constitución");
		Constiticion.setBounds(990, 755, 140, 25);
		panel.add(Constiticion);

		JLabel A = new JLabel("A");
		A.setBounds(1272, 554, 140, 25);
		A.setFont(new Font("Arial", Font.ITALIC, 24));
		A.setForeground(Color.WHITE);
		panel.add(A);
		JLabel B = new JLabel("B");
		B.setBounds(1271, 603, 140, 25);
		B.setFont(new Font("Arial", Font.ITALIC, 24));
		B.setForeground(Color.WHITE);
		panel.add(B);
		JLabel C = new JLabel("C");
		C.setBounds(1270, 654, 140, 25);
		C.setFont(new Font("Arial", Font.ITALIC, 24));
		C.setForeground(Color.WHITE);
		panel.add(C);
		JLabel D = new JLabel("D");
		D.setBounds(1271, 704, 140, 25);
		D.setFont(new Font("Arial", Font.ITALIC, 24));
		D.setForeground(Color.WHITE);
		panel.add(D);
		JLabel E = new JLabel("E");
		E.setBounds(576, 632, 140, 25);
		E.setFont(new Font("Arial", Font.ITALIC, 24));
		E.setForeground(Color.WHITE);
		panel.add(E);

		JLabel A2 = new JLabel("A");
		A2.setBounds(532, 358, 140, 25);
		A2.setFont(new Font("Arial", Font.ITALIC, 24));
		A2.setForeground(Color.WHITE);
		panel.add(A2);
		JLabel B2 = new JLabel("B");
		B2.setBounds(579, 235, 140, 25);
		B2.setFont(new Font("Arial", Font.ITALIC, 24));
		B2.setForeground(Color.WHITE);
		panel.add(B2);
		JLabel C2 = new JLabel("C");
		C2.setBounds(931, 759, 140, 25);
		C2.setFont(new Font("Arial", Font.ITALIC, 24));
		C2.setForeground(Color.WHITE);
		panel.add(C2);
		JLabel D2 = new JLabel("D");
		D2.setBounds(566, 149, 140, 25);
		D2.setFont(new Font("Arial", Font.ITALIC, 24));
		D2.setForeground(Color.WHITE);
		panel.add(D2);
		JLabel E2 = new JLabel("E");
		E2.setBounds(1271, 754, 140, 25);
		E2.setFont(new Font("Arial", Font.ITALIC, 24));
		E2.setForeground(Color.WHITE);
		panel.add(E2);

		frame.setVisible(true);
	}

	public static void pintar(Nodo n1, Nodo n2, Graphics2D g) {
		g.setColor(Color.ORANGE);
		g.setStroke(new BasicStroke(4));
		if (n1.nombre.equals("Facultad de Medicina") && n2.nombre.equals("Callao")
				|| n2.nombre.equals("Facultad de Medicina") && n1.nombre.equals("Callao")) {
			g.drawLine(600 + 9, 150 + 9, 745 + 9, 150 + 9);
			g.fillOval(604, 154, 11, 11);
			g.fillOval(749, 154, 11, 11);
		} else if (n1.nombre.equals("Callao") && n2.nombre.equals("Tribunales")
				|| n2.nombre.equals("Callao") && n1.nombre.equals("Tribunales")) {
			g.drawLine(745 + 9, 150 + 9, 860 + 9, 200 + 9);
			g.fillOval(749, 154, 11, 11);
			g.fillOval(864, 204, 11, 11);
		} else if (n1.nombre.equals("Tribunales") && n2.nombre.equals("9 de Julio")
				|| n2.nombre.equals("Tribunales") && n1.nombre.equals("9 de Julio")) {
			g.drawLine(860 + 9, 200 + 9, 990 + 9, 265 + 9);
			g.fillOval(864, 204, 11, 11);
			g.fillOval(994, 269, 11, 11);
		} else if (n1.nombre.equals("9 de Julio") && n2.nombre.equals("Diagonal Norte")
				|| n2.nombre.equals("9 de Julio") && n1.nombre.equals("Diagonal Norte")) {
			g.drawLine(1025 + 9, 280 + 9, 990 + 9, 265 + 9);
			g.fillOval(994, 269, 11, 11);
			g.fillOval(1029, 284, 11, 11);
		} else if (n1.nombre.equals("9 de Julio") && n2.nombre.equals("Carlos Pellegrini")
				|| n2.nombre.equals("9 de Julio") && n1.nombre.equals("Carlos Pellegrini")) {
			g.drawLine(990 + 9, 237 + 9, 990 + 9, 265 + 9);
			g.fillOval(994, 269, 11, 11);
			g.fillOval(994, 241, 11, 11);
		} else if (n1.nombre.equals("9 de Julio") && n2.nombre.equals("Catedral")
				|| n2.nombre.equals("9 de Julio") && n1.nombre.equals("Catedral")) {
			g.drawLine(990 + 9, 265 + 9, 1130 + 9, 327 + 9);
			g.fillOval(994, 269, 11, 11);
			g.fillOval(1134, 331, 11, 11);
		} else if (n1.nombre.equals("Catedral") && n2.nombre.equals("Bolívar")
				|| n2.nombre.equals("Catedral") && n1.nombre.equals("Bolívar")) {
			g.drawLine(1130 + 9, 327 + 9, 1130 + 9, 360 + 9);
			g.drawLine(1130 + 9, 395 + 9, 1130 + 9, 360 + 9);
			g.fillOval(1134, 331, 11, 11);
			g.fillOval(1134, 399, 11, 11);
		} else if (n1.nombre.equals("Alberti") && n2.nombre.equals("Pasco")
				|| n2.nombre.equals("Alberti") && n1.nombre.equals("Pasco")) {
			g.drawLine(565 + 9, 360 + 9, 650 + 9, 360 + 9);
			g.fillOval(569, 364, 11, 11);
			g.fillOval(654, 364, 11, 11);
		} else if (n1.nombre.equals("Pasco") && n2.nombre.equals("Congreso")
				|| n2.nombre.equals("Pasco") && n1.nombre.equals("Congreso")) {
			g.drawLine(740 + 9, 360 + 9, 650 + 9, 360 + 9);
			g.fillOval(654, 364, 11, 11);
			g.fillOval(744, 364, 11, 11);
		} else if (n1.nombre.equals("Congreso") && n2.nombre.equals("Sáenz Peña")
				|| n2.nombre.equals("Congreso") && n1.nombre.equals("Sáenz Peña")) {
			g.drawLine(740 + 9, 360 + 9, 830 + 9, 360 + 9);
			g.fillOval(744, 364, 11, 11);
			g.fillOval(834, 364, 11, 11);
		} else if (n1.nombre.equals("Sáenz Peña") && n2.nombre.equals("Lima")
				|| n2.nombre.equals("Sáenz Peña") && n1.nombre.equals("Lima")) {
			g.drawLine(910 + 9, 360 + 9, 830 + 9, 360 + 9);
			g.fillOval(834, 364, 11, 11);
			g.fillOval(914, 364, 11, 11);
		} else if (n1.nombre.equals("Avenida de Mayo") && n2.nombre.equals("Lima")
				|| n2.nombre.equals("Avenida de Mayo") && n1.nombre.equals("Lima")) {
			g.drawLine(910 + 9, 360 + 9, 965 + 9, 360 + 9);
			g.fillOval(914, 364, 11, 11);
			g.fillOval(969, 364, 11, 11);
		} else if (n1.nombre.equals("Piedras") && n2.nombre.equals("Lima")
				|| n2.nombre.equals("Piedras") && n1.nombre.equals("Lima")) {
			g.drawLine(910 + 9, 360 + 9, 1045 + 9, 360 + 9);
			g.fillOval(914, 364, 11, 11);
			g.fillOval(1049, 364, 11, 11);
		} else if (n1.nombre.equals("Piedras") && n2.nombre.equals("Perú")
				|| n2.nombre.equals("Piedras") && n1.nombre.equals("Perú")) {
			g.drawLine(1105 + 9, 360 + 9, 1045 + 9, 360 + 9);
			g.fillOval(1049, 364, 11, 11);
			g.fillOval(1109, 364, 11, 11);
		} else if (n1.nombre.equals("Catedral") && n2.nombre.equals("Perú")
				|| n2.nombre.equals("Catedral") && n1.nombre.equals("Perú")) {
			g.drawLine(1105 + 9, 360 + 9, 1130 + 9, 360 + 9);
			g.drawLine(1130 + 9, 327 + 9, 1130 + 9, 360 + 9);
			g.fillOval(1109, 364, 11, 11);
			g.fillOval(1134, 331, 11, 11);
		} else if (n1.nombre.equals("Bolívar") && n2.nombre.equals("Perú")
				|| n2.nombre.equals("Bolívar") && n1.nombre.equals("Perú")) {
			g.drawLine(1105 + 9, 360 + 9, 1130 + 9, 360 + 9);
			g.drawLine(1130 + 9, 395 + 9, 1130 + 9, 360 + 9);
			g.fillOval(1109, 364, 11, 11);
			g.fillOval(1134, 399, 11, 11);
		} else if (n1.nombre.equals("Plaza de Mayo") && n2.nombre.equals("Perú")
				|| n2.nombre.equals("Plaza de Mayo") && n1.nombre.equals("Perú")) {
			g.drawLine(1105 + 9, 360 + 9, 1200 + 9, 360 + 9);
			g.fillOval(1109, 364, 11, 11);
			g.fillOval(1204, 364, 11, 11);
		} else if (n1.nombre.equals("Pasteur") && n2.nombre.equals("Callao")
				|| n2.nombre.equals("Pasteur") && n1.nombre.equals("Callao")) {
			g.drawLine(613 + 9, 237 + 9, 743 + 9, 237 + 9);
			g.fillOval(616, 241, 11, 11);
			g.fillOval(747, 241, 11, 11);
		} else if (n1.nombre.equals("Callao") && n2.nombre.equals("Uruguay")
				|| n2.nombre.equals("Callao") && n1.nombre.equals("Uruguay")) {
			g.drawLine(830 + 9, 237 + 9, 743 + 9, 237 + 9);
			g.fillOval(747, 241, 11, 11);
			g.fillOval(834, 241, 11, 11);
		} else if (n1.nombre.equals("Uruguay") && n2.nombre.equals("Carlos Pellegrini")
				|| n2.nombre.equals("Uruguay") && n1.nombre.equals("Carlos Pellegrini")) {
			g.drawLine(830 + 9, 237 + 9, 990 + 9, 237 + 9);
			g.fillOval(834, 241, 11, 11);
			g.fillOval(994, 241, 11, 11);
		} else if (n1.nombre.equals("Carlos Pellegrini") && n2.nombre.equals("Florida")
				|| n2.nombre.equals("Carlos Pellegrini") && n1.nombre.equals("Florida")) {
			g.drawLine(1120 + 9, 237 + 9, 990 + 9, 237 + 9);
			g.fillOval(994, 241, 11, 11);
			g.fillOval(1124, 241, 11, 11);
		} else if (n1.nombre.equals("Florida") && n2.nombre.equals("Leandro N. Alem")
				|| n2.nombre.equals("Florida") && n1.nombre.equals("Leandro N. Alem")) {
			g.drawLine(1120 + 9, 237 + 9, 1220 + 9, 237 + 9);
			g.fillOval(1124, 241, 11, 11);
			g.fillOval(1224, 241, 11, 11);
		} else if (n1.nombre.equals("Retiro") && n2.nombre.equals("General San Martín")
				|| n2.nombre.equals("Retiro") && n1.nombre.equals("General San Martín")) {
			g.drawLine(1223 + 9, 60 + 9, 1135 + 9, 115 + 9);
			g.fillOval(1227, 64, 11, 11);
			g.fillOval(1139, 119, 11, 11);
		} else if (n1.nombre.equals("General San Martín") && n2.nombre.equals("Lavalle")
				|| n2.nombre.equals("General San Martín") && n1.nombre.equals("Lavalle")) {
			g.drawLine(1065 + 9, 210 + 9, 1065 + 9, 160 + 9);
			g.drawLine(1065 + 9, 160 + 9, 1135 + 9, 115 + 9);
			g.fillOval(1139, 119, 11, 11);
			g.fillOval(1069, 214, 11, 11);
		} else if (n1.nombre.equals("Lavalle") && n2.nombre.equals("Diagonal Norte")
				|| n2.nombre.equals("Lavalle") && n1.nombre.equals("Diagonal Norte")) {
			g.drawLine(1035, 280 + 9, 1065 + 9, 280 + 9);
			g.drawLine(1065 + 9, 280 + 9, 1065 + 9, 210 + 9);
			g.fillOval(1069, 214, 11, 11);
			g.fillOval(1029, 284, 11, 11);
		} else if (n1.nombre.equals("Diagonal Norte") && n2.nombre.equals("Avenida de Mayo")
				|| n2.nombre.equals("Diagonal Norte") && n1.nombre.equals("Avenida de Mayo")) {
			g.drawLine(965 + 9, 280 + 9, 1035, 280 + 9);
			g.drawLine(965 + 9, 280 + 9, 965 + 9, 360 + 9);
			g.fillOval(1029, 284, 11, 11);
			g.fillOval(969, 364, 11, 11);
		} else if (n1.nombre.equals("Avenida de Mayo") && n2.nombre.equals("Moreno")
				|| n2.nombre.equals("Avenida de Mayo") && n1.nombre.equals("Moreno")) {
			g.drawLine(965 + 9, 420 + 9, 965 + 9, 360 + 9);
			g.fillOval(969, 364, 11, 11);
			g.fillOval(969, 424, 11, 11);
		} else if (n1.nombre.equals("Moreno") && n2.nombre.equals("Independencia")
				|| n2.nombre.equals("Moreno") && n1.nombre.equals("Independencia")) {
			g.drawLine(965 + 9, 420 + 9, 965 + 9, 545 + 9);
			g.fillOval(969, 424, 11, 11);
			g.fillOval(969, 549, 11, 11);
		} else if (n1.nombre.equals("Independencia") && n2.nombre.equals("San Juan")
				|| n2.nombre.equals("Independencia") && n1.nombre.equals("San Juan")) {
			g.drawLine(965 + 9, 635 + 9, 965 + 9, 545 + 9);
			g.fillOval(969, 549, 11, 11);
			g.fillOval(969, 639, 11, 11);
		} else if (n1.nombre.equals("San Juan") && n2.nombre.equals("Constitución")
				|| n2.nombre.equals("San Juan") && n1.nombre.equals("Constitución")) {
			g.drawLine(965 + 9, 635 + 9, 965 + 9, 760 + 9);
			g.fillOval(969, 639, 11, 11);
			g.fillOval(969, 764, 11, 11);
		} else if (n1.nombre.equals("Pichincha") && n2.nombre.equals("Entre Ríos")
				|| n2.nombre.equals("Pichincha") && n1.nombre.equals("Entre Ríos")) {
			g.drawLine(610 + 9, 635 + 9, 740 + 9, 635 + 9);
			g.fillOval(614, 639, 11, 11);
			g.fillOval(744, 639, 11, 11);
		} else if (n1.nombre.equals("San José") && n2.nombre.equals("Entre Ríos")
				|| n2.nombre.equals("San José") && n1.nombre.equals("Entre Ríos")) {
			g.drawLine(830 + 9, 635 + 9, 740 + 9, 635 + 9);
			g.fillOval(744, 639, 11, 11);
			g.fillOval(834, 639, 11, 11);
		} else if (n1.nombre.equals("San José") && n2.nombre.equals("Independencia")
				|| n2.nombre.equals("San José") && n1.nombre.equals("Independencia")) {
			g.drawLine(830 + 9, 635 + 9, 880 + 9, 635 + 9);
			g.drawLine(880 + 9, 545 + 9, 880 + 9, 635 + 9);
			g.fillOval(834, 639, 11, 11);
			g.fillOval(884, 549, 11, 11);
		} else if (n1.nombre.equals("Independencia") && n2.nombre.equals("Independencia")
				|| n2.nombre.equals("Independencia") && n1.nombre.equals("Independencia")) {
			g.drawLine(965 + 9, 545 + 9, 880 + 9, 545 + 9);
			g.fillOval(884, 549, 11, 11);
			g.fillOval(969, 549, 11, 11);
		} else if (n1.nombre.equals("Belgrano") && n2.nombre.equals("Independencia")
				|| n2.nombre.equals("Belgrano") && n1.nombre.equals("Independencia")) {
			g.drawLine(880 + 9, 545 + 9, 880 + 9, 525 + 9);
			g.drawLine(880 + 9, 525 + 9, 1010 + 9, 460 + 9);
			g.fillOval(884, 549, 11, 11);
			g.fillOval(1014, 464, 11, 11);
		} else if (n1.nombre.equals("Belgrano") && n2.nombre.equals("Bolívar")
				|| n2.nombre.equals("Belgrano") && n1.nombre.equals("Bolívar")) {
			g.drawLine(1130 + 9, 395 + 9, 1010 + 9, 460 + 9);
			g.fillOval(1014, 464, 11, 11);
			g.fillOval(1134, 399, 11, 11);
		}
	}

	public static void inicializarNodos() {
		Nodo Alberti = new Nodo("Alberti", -34.609861, -58.401361);
		Nodo Pasco = new Nodo("Pasco", -34.609667, -58.398444);
		Nodo Congreso = new Nodo("Congreso", -34.609278, -58.392806);
		Nodo SaenzPeña = new Nodo("Sáenz Peña", -34.609444, -58.386806);
		Nodo Lima = new Nodo("Lima", -34.609111, -58.382083);
		Nodo Piedras = new Nodo("Piedras", -34.608889, -58.379083);
		Nodo Peru = new Nodo("Perú", -34.60858, -58.3745);
		Nodo PlazaDeMayo = new Nodo("Plaza de Mayo", -34.608861, -58.370833);

		Nodo Pasteur = new Nodo("Pasteur", -34.604639, -58.399472);
		Nodo Callao = new Nodo("Callao", -34.604444, -58.39225);
		Nodo Uruguay = new Nodo("Uruguay", -34.6041, -58.3872);
		Nodo CarlosPellegrini = new Nodo("Carlos Pellegrini", -34.603639, -58.380722);
		Nodo Florida = new Nodo("Florida", -34.603333, -58.375111);
		Nodo LeandroNAlem = new Nodo("Leandro N. Alem", -34.602778, -58.37);

		Nodo Constitucion = new Nodo("Constitución", -34.627778, -58.381306);
		Nodo SanJuan = new Nodo("San Juan", -34.621917, -58.38);
		Nodo Independencia = new Nodo("Independencia", -34.618111, -58.38025);
		Nodo Moreno = new Nodo("Moreno", -34.612611, -58.380583);
		Nodo AvenidaDeMayo = new Nodo("Avenida de Mayo", -34.609, -58.380611);
		Nodo DiagonalNorte = new Nodo("Diagonal Norte", -34.604722, -58.379667);
		Nodo Lavalle = new Nodo("Lavalle", -34.601806, -58.378139);
		Nodo GeneralSanMartin = new Nodo("General San Martín", -34.595083, -58.377889);
		Nodo Retiro = new Nodo("Retiro", -34.59125, -58.374028);

		Nodo FacultadDeMedicina = new Nodo("Facultad de Medicina", -34.5997780, -58.3976670);
		Nodo CallaoV = new Nodo("Callao", -34.5996390, -58.3931110);
		Nodo Tribunales = new Nodo("Tribunales", -34.6021000, -58.3841000);
		Nodo NueveDeJulio = new Nodo("9 de Julio", -34.6043000, -58.3805000);
		Nodo Catedral = new Nodo("Catedral", -34.6077500, -58.3739720);

		Nodo Pichincha = new Nodo("Pichincha", -34.623139, -58.397139);
		Nodo EntreRios = new Nodo("Entre Ríos", -34.622722, -58.391472);
		Nodo SanJose = new Nodo("San José", -34.622333, -58.385139);
		Nodo IndependenciaM = new Nodo("Independencia", -34.617944, -58.3815);
		Nodo Belgrano = new Nodo("Belgrano", -34.612861, -58.377528);
		Nodo Bolivar = new Nodo("Bolívar", -34.609083, -58.373639);

		Alberti.vecinos.add(Pasco);
		Pasco.vecinos.add(Alberti);
		Pasco.vecinos.add(Congreso);
		Congreso.vecinos.add(Pasco);
		Congreso.vecinos.add(SaenzPeña);
		SaenzPeña.vecinos.add(Congreso);
		SaenzPeña.vecinos.add(Lima);
		Lima.vecinos.add(SaenzPeña);
		Lima.vecinos.add(Piedras);
		Lima.vecinos.add(AvenidaDeMayo);
		Piedras.vecinos.add(Lima);
		Piedras.vecinos.add(Peru);
		Peru.vecinos.add(Piedras);
		Peru.vecinos.add(PlazaDeMayo);
		Peru.vecinos.add(Catedral);
		Peru.vecinos.add(Bolivar);
		PlazaDeMayo.vecinos.add(Peru);

		Pasteur.vecinos.add(Callao);
		Callao.vecinos.add(Pasteur);
		Callao.vecinos.add(Uruguay);
		Uruguay.vecinos.add(Callao);
		Uruguay.vecinos.add(CarlosPellegrini);
		CarlosPellegrini.vecinos.add(Uruguay);
		CarlosPellegrini.vecinos.add(Florida);
		CarlosPellegrini.vecinos.add(NueveDeJulio);
		Florida.vecinos.add(CarlosPellegrini);
		Florida.vecinos.add(LeandroNAlem);
		LeandroNAlem.vecinos.add(Florida);

		Constitucion.vecinos.add(SanJuan);
		SanJuan.vecinos.add(Constitucion);
		SanJuan.vecinos.add(Independencia);
		Independencia.vecinos.add(SanJuan);
		Independencia.vecinos.add(IndependenciaM);
		Independencia.vecinos.add(Moreno);
		Moreno.vecinos.add(Independencia);
		Moreno.vecinos.add(AvenidaDeMayo);
		AvenidaDeMayo.vecinos.add(Moreno);
		AvenidaDeMayo.vecinos.add(Lima);
		AvenidaDeMayo.vecinos.add(DiagonalNorte);
		DiagonalNorte.vecinos.add(AvenidaDeMayo);
		DiagonalNorte.vecinos.add(Lavalle);
		DiagonalNorte.vecinos.add(NueveDeJulio);
		Lavalle.vecinos.add(DiagonalNorte);
		Lavalle.vecinos.add(GeneralSanMartin);
		GeneralSanMartin.vecinos.add(Lavalle);
		GeneralSanMartin.vecinos.add(Retiro);
		Retiro.vecinos.add(GeneralSanMartin);

		FacultadDeMedicina.vecinos.add(CallaoV);
		CallaoV.vecinos.add(FacultadDeMedicina);
		CallaoV.vecinos.add(Tribunales);
		Tribunales.vecinos.add(CallaoV);
		Tribunales.vecinos.add(NueveDeJulio);
		NueveDeJulio.vecinos.add(Tribunales);
		NueveDeJulio.vecinos.add(Catedral);
		NueveDeJulio.vecinos.add(DiagonalNorte);
		NueveDeJulio.vecinos.add(CarlosPellegrini);
		Catedral.vecinos.add(NueveDeJulio);
		Catedral.vecinos.add(Peru);
		Catedral.vecinos.add(Bolivar);

		Pichincha.vecinos.add(EntreRios);
		EntreRios.vecinos.add(Pichincha);
		EntreRios.vecinos.add(SanJose);
		SanJose.vecinos.add(EntreRios);
		SanJose.vecinos.add(IndependenciaM);
		IndependenciaM.vecinos.add(SanJose);
		IndependenciaM.vecinos.add(Independencia);
		IndependenciaM.vecinos.add(Belgrano);
		Belgrano.vecinos.add(IndependenciaM);
		Belgrano.vecinos.add(Bolivar);
		Bolivar.vecinos.add(Belgrano);
		Bolivar.vecinos.add(Peru);
		Bolivar.vecinos.add(Catedral);

		mapaS.put("Facultad de Medicina", FacultadDeMedicina);
		mapaS.put("Callao Línea D", CallaoV);
		mapaS.put("Tribunales", Tribunales);
		mapaS.put("9 de Julio", NueveDeJulio);
		mapaS.put("Catedral", Catedral);
		mapaS.put("Pasteur", Pasteur);
		mapaS.put("Callao Línea B", Callao);
		mapaS.put("Uruguay", Uruguay);
		mapaS.put("Carlos Pellegrini", CarlosPellegrini);
		mapaS.put("Florida", Florida);
		mapaS.put("Leandro N. Alem", LeandroNAlem);
		mapaS.put("Alberti", Alberti);
		mapaS.put("Pasco", Pasco);
		mapaS.put("Congreso", Congreso);
		mapaS.put("Sáenz Peña", SaenzPeña);
		mapaS.put("Lima", Lima);
		mapaS.put("Piedras", Piedras);
		mapaS.put("Perú", Peru);
		mapaS.put("Plaza de Mayo", PlazaDeMayo);
		mapaS.put("Pichincha", Pichincha);
		mapaS.put("Entre Ríos", EntreRios);
		mapaS.put("San José", SanJose);
		mapaS.put("Independencia Línea E", IndependenciaM);
		mapaS.put("Belgrano", Belgrano);
		mapaS.put("Bolívar", Bolivar);
		mapaS.put("Retiro", Retiro);
		mapaS.put("General San Martín", GeneralSanMartin);
		mapaS.put("Lavalle", Lavalle);
		mapaS.put("Diagonal Norte", DiagonalNorte);
		mapaS.put("Avenida de Mayo", AvenidaDeMayo);
		mapaS.put("Moreno", Moreno);
		mapaS.put("Independencia Línea C", Independencia);
		mapaS.put("San Juan", SanJuan);
		mapaS.put("Constitución", Constitucion);
	}

	public static void main(String[] args) {
		GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		inicializarNodos();
		String inicio = (String) inicioBox.getSelectedItem();
		String destino = (String) DestinoBox.getSelectedItem();
		if (inicio != null && destino != null) {
			res.setText("");
			res.append("     Ruta " + inicio + " - " + destino + ":\n\n");
			camino = a_estrella(mapaS.get(inicio), mapaS.get(destino));
			for (Nodo Nodo : camino) {
				res.append("       - " + Nodo.nombre + "\n");
			}
			res.append("\n     Distancia Total: " + String.format("%.2f", distanciaTotal) + " km");
			distanciaTotal = 0;
			panel.func(camino);
			panel.repaint();
		}
	}
}

class CustomPanel extends JPanel {
	private Image imagen_UPM, imagen_cuad;
	private Graphics2D g2;
	private LinkedList<Nodo> camino;
	private boolean interruptor = false;

	public void setImage(Image imagen_UPM, Image imagen_cuad) {
		this.imagen_UPM = imagen_UPM;
		this.imagen_cuad = imagen_cuad;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;

		if (imagen_UPM != null && imagen_cuad != null) {
			g2.drawImage(imagen_cuad, 0, 0, 1536, 864, this);
			g2.drawImage(imagen_UPM, 1350, 20, 150, 100, this);
		}

		g2.setColor(Color.GRAY);
		g2.fillRoundRect(50, 50, 415, 250, 50, 50);
		g2.fillRect(50, 75, 415, 250);
		g2.fillRoundRect(1240, 530, 265, 500, 50, 50);

		g2.setStroke(new BasicStroke(8));
		g2.setColor(Color.GREEN);
		g2.fillOval(600, 150, 18, 18); // Facultad de Medicina
		g2.fillOval(745, 150, 18, 18); // CallaoD
		g2.drawLine(600 + 9, 150 + 9, 745 + 9, 150 + 9);
		g2.fillOval(860, 200, 18, 18); // Tribunales
		g2.drawLine(745 + 9, 150 + 9, 860 + 9, 200 + 9);
		g2.fillOval(990, 265, 18, 18); // 9 de Julio
		g2.drawLine(860 + 9, 200 + 9, 990 + 9, 265 + 9);
		g2.fillOval(1130, 327, 18, 18); // Catedral
		g2.drawLine(990 + 9, 265 + 9, 1130 + 9, 327 + 9);
		g2.setColor(Color.RED);
		g2.fillOval(613, 237, 18, 18); // Pasteur
		g2.fillOval(743, 237, 18, 18); // CallaoA
		g2.drawLine(613 + 9, 237 + 9, 743 + 9, 237 + 9);
		g2.fillOval(830, 237, 18, 18); // Uruguay
		g2.drawLine(830 + 9, 237 + 9, 743 + 9, 237 + 9);
		g2.fillOval(990, 237, 18, 18); // Carlos Pellegrini
		g2.drawLine(830 + 9, 237 + 9, 990 + 9, 237 + 9);
		g2.fillOval(1120, 237, 18, 18); // Florida
		g2.drawLine(1120 + 9, 237 + 9, 990 + 9, 237 + 9);
		g2.fillOval(1220, 237, 18, 18); // Leandro N. Alem
		g2.drawLine(1120 + 9, 237 + 9, 1220 + 9, 237 + 9);
		g2.setColor(Color.cyan);
		g2.fillOval(565, 360, 18, 18); // Alberti
		g2.fillOval(650, 360, 18, 18); // Pasco
		g2.drawLine(565 + 9, 360 + 9, 650 + 9, 360 + 9);
		g2.fillOval(740, 360, 18, 18); // Congreso
		g2.drawLine(740 + 9, 360 + 9, 650 + 9, 360 + 9);
		g2.fillOval(830, 360, 18, 18); // Sáenz
		g2.drawLine(740 + 9, 360 + 9, 830 + 9, 360 + 9);
		g2.drawLine(910 + 9, 360 + 9, 830 + 9, 360 + 9);
		g2.drawLine(910 + 9, 360 + 9, 1045 + 9, 360 + 9);
		g2.fillOval(910, 360, 18, 18); // Lima
		g2.fillOval(1045, 360, 18, 18); // Piedras
		g2.fillOval(1105, 360, 18, 18); // Perú
		g2.drawLine(1105 + 9, 360 + 9, 1045 + 9, 360 + 9);
		g2.drawLine(1105 + 9, 360 + 9, 1200 + 9, 360 + 9);
		g2.fillOval(1200, 360, 18, 18); // Plaza Mayo
		g2.setColor(Color.MAGENTA);
		g2.fillOval(610, 635, 18, 18); // Pichincha
		g2.fillOval(740, 635, 18, 18); // Entre ríos
		g2.drawLine(610 + 9, 635 + 9, 740 + 9, 635 + 9);
		g2.fillOval(830, 635, 18, 18); // San Jose
		g2.drawLine(830 + 9, 635 + 9, 740 + 9, 635 + 9);
		g2.fillOval(880, 545, 18, 18); // IndependenciaE
		g2.drawLine(830 + 9, 635 + 9, 880 + 9, 635 + 9);
		g2.drawLine(880 + 9, 545 + 9, 880 + 9, 635 + 9);
		g2.fillOval(1010, 460, 18, 18); // Belgrano
		g2.drawLine(880 + 9, 545 + 9, 880 + 9, 525 + 9);
		g2.drawLine(880 + 9, 525 + 9, 1010 + 9, 460 + 9);
		g2.fillOval(1130, 395, 18, 18); // Bolívar
		g2.drawLine(1130 + 9, 395 + 9, 1010 + 9, 460 + 9);
		g2.setColor(Color.BLUE);
		g2.fillOval(1223, 60, 18, 18); // Retiro
		g2.fillOval(1135, 115, 18, 18); // General San Martín
		g2.drawLine(1223 + 9, 60 + 9, 1135 + 9, 115 + 9);
		g2.fillOval(1065, 210, 18, 18); // Lavalle
		g2.drawLine(1065 + 9, 210 + 9, 1065 + 9, 160 + 9);
		g2.drawLine(1065 + 9, 160 + 9, 1135 + 9, 115 + 9);
		g2.fillOval(1025, 280, 18, 18); // Diagonal Norte
		g2.drawLine(1035 + 9, 280 + 9, 1065 + 9, 280 + 9);
		g2.drawLine(1065 + 9, 280 + 9, 1065 + 9, 210 + 9);
		g2.fillOval(965, 360, 18, 18); // Avenida de Mayo
		g2.drawLine(965 + 9, 280 + 9, 1035, 280 + 9);
		g2.drawLine(965 + 9, 280 + 9, 965 + 9, 360 + 9);
		g2.fillOval(965, 420, 18, 18); // Moreno
		g2.drawLine(965 + 9, 420 + 9, 965 + 9, 360 + 9);
		g2.fillOval(965, 545, 18, 18); // IndependenciaD
		g2.drawLine(965 + 9, 420 + 9, 965 + 9, 545 + 9);
		g2.fillOval(965, 635, 18, 18); // San Juan
		g2.drawLine(965 + 9, 635 + 9, 965 + 9, 545 + 9);
		g2.fillOval(965, 760, 18, 18); // Constitución
		g2.drawLine(965 + 9, 635 + 9, 965 + 9, 760 + 9);

		// Puntos blancos
		g2.setColor(Color.white);
		g2.fillOval(604, 154, 11, 11); // Facultad de Medicina
		g2.fillOval(749, 154, 11, 11); // CallaoD
		g2.fillOval(864, 204, 11, 11); // Tribunales
		g2.fillOval(994, 269, 11, 11); // 9 de Julio
		g2.fillOval(1134, 331, 11, 11); // Catedral
		g2.fillOval(616, 241, 11, 11); // Pasteur
		g2.fillOval(747, 241, 11, 11); // CallaoA
		g2.fillOval(834, 241, 11, 11); // Uruguay
		g2.fillOval(994, 241, 11, 11); // Carlos Pellegrini
		g2.fillOval(1124, 241, 11, 11); // Florida
		g2.fillOval(1224, 241, 11, 11); // Leandro N. Alem
		g2.fillOval(569, 364, 11, 11); // Alberti
		g2.fillOval(654, 364, 11, 11); // Pasco
		g2.fillOval(744, 364, 11, 11); // Congreso
		g2.fillOval(834, 364, 11, 11); // Sáenz
		g2.fillOval(914, 364, 11, 11); // Lima
		g2.fillOval(1049, 364, 11, 11); // Piedras
		g2.fillOval(1109, 364, 11, 11); // Perú
		g2.fillOval(1204, 364, 11, 11); // Plaza Mayo
		g2.fillOval(614, 639, 11, 11); // pichincha
		g2.fillOval(744, 639, 11, 11); // Entre ríos
		g2.fillOval(834, 639, 11, 11); // San José
		g2.fillOval(884, 549, 11, 11); // IndependenciaE
		g2.fillOval(1014, 464, 11, 11); // Belgrano
		g2.fillOval(1134, 399, 11, 11); // Bolívar
		g2.fillOval(1227, 64, 11, 11); // Retiro
		g2.fillOval(1139, 119, 11, 11); // General San Martín
		g2.fillOval(1069, 214, 11, 11); // Lavalle
		g2.fillOval(1029, 284, 11, 11); // Diagonal Norte
		g2.fillOval(969, 364, 11, 11); // Avenida de Mayo
		g2.fillOval(969, 424, 11, 11); // Moreno
		g2.fillOval(969, 549, 11, 11); // IndependenciaD
		g2.fillOval(969, 639, 11, 11); // San Juan
		g2.fillOval(969, 764, 11, 11); // Constitución
		g2.setStroke(new BasicStroke(4));
		g2.drawLine(965 + 9, 545 + 9, 880 + 9, 545 + 9);
		g2.drawLine(1105 + 9, 360 + 9, 1130 + 9, 360 + 9);
		g2.drawLine(1130 + 9, 327 + 9, 1130 + 9, 360 + 9);
		g2.drawLine(1130 + 9, 395 + 9, 1130 + 9, 360 + 9);
		g2.drawLine(1025 + 9, 280 + 9, 990 + 9, 265 + 9);
		g2.drawLine(990 + 9, 237 + 9, 990 + 9, 265 + 9);
		g2.drawLine(910 + 9, 360 + 9, 965 + 9, 360 + 9);

		g2.setColor(Color.MAGENTA);
		g2.fillOval(1265, 750, 30, 30);
		g2.setColor(Color.GREEN);
		g2.fillOval(1265, 700, 30, 30);
		g2.setColor(Color.BLUE);
		g2.fillOval(1265, 650, 30, 30);
		g2.setColor(Color.RED);
		g2.fillOval(1265, 600, 30, 30);
		g2.setColor(Color.CYAN);
		g2.fillOval(1265, 550, 30, 30);

		g2.setColor(Color.MAGENTA);
		g2.fillOval(570, 629, 30, 30);
		g2.setColor(Color.GREEN);
		g2.fillOval(560, 145, 30, 30);
		g2.setColor(Color.BLUE);
		g2.fillOval(926, 755, 30, 30);
		g2.setColor(Color.RED);
		g2.fillOval(573, 231, 30, 30);
		g2.setColor(Color.CYAN);
		g2.fillOval(525, 354, 30, 30);

		if (interruptor) {
			for (int i = 0; i + 1 < camino.size(); i++) {
				Metro.pintar(camino.get(i), camino.get(i + 1), g2);
			}
		}
	}

	public void func(LinkedList<Nodo> camino) {
		this.camino = camino;
		interruptor = true;
	}

}