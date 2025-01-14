package pp1;

public class EvaluarEstadosObjetos {
    public static void main(String[] args) {
        // creamos un objeto (Entidad en el contexto Hibernate)
        Alumno alu = new Alumno("Patricia Gómez");
        
        // CHK 1 - ¿Transitorio?
        
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        // guardamos
        em.persist(alu); // alu pasa a estar asociado al contexto de persistencia
        
        // CHK 2 - ¿Persistente?
        // modificamos
        alu.setNombre("Patricia Gómez Pérez"); // (Persistente - cambios sincronizados con la BD)
        
        // recuperamos el ID que habrá generado el SGBD
        Long idAlu = alu.getId();
        tx.commit();
        em.close(); // el EntityManager se cierra, el objeto se separa
        
        // CHK 3 - ¿Separado?
        
        em = entityManagerFactory.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
        
        // recuperamos mediante el idAlu
        alu = em.find(Alumno.class, idAlu); // (Persistente - objeto recuperado del contexto)
        
        // CHK 4 - ¿Persistente?
        
        tx.commit();
        em.close(); // el EntityManager se cierra
        
        // CHK 5 - ¿Separado?
        
        // de quien será sobrina???
        alu.setEmail("Patricia Gómez Pérez-Reverte"); // (Separado - cambios no sincronizados con la BD)
        
        em = entityManagerFactory.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
        
        // fusionamos
        alu = em.merge(alu); // (Persistente - vuelve al contexto de persistencia)
        
        // CHK 6 - ¿Persistente?
        
        tx.commit();
        em.close();
        System.out.println(alu); // (Separado - después de cerrar el EntityManager)
        
        em = entityManagerFactory.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
        
        // recuperamos
        alu = em.find(Alumno.class, idAlu); // (Persistente)
        em.remove(alu); // marcado para eliminación
        
        // CHK 7 - ¿Eliminado - será eliminado al confirmar la transacción?
        
        tx.commit();
        em.close();
    }
}
