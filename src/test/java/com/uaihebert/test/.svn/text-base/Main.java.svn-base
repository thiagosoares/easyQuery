package com.uaihebert.test;

import com.uaihebert.model.test.Manufacturer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

public class Main extends AbstractTest {

    public static void main(String[] args) throws Exception {
        createEntityManagerFactoryForEclipseLink();
//        EntityManagerFactory factory = CodeGenerator.createEntityManagerFactoryForOpenJPA();
        CodeGenerator.generateData(getEntityManagerFactory());

        EntityManager em = getEntityManagerFactory().createEntityManager();

//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
//        Root<Manufacturer> mainRoot = criteriaQuery.from(Manufacturer.class);
//        criteriaQuery.select(criteriaBuilder.count(mainRoot));
        CriteriaBuilder countCriteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Long> countCriteriaQuery = countCriteriaBuilder.createQuery(Long.class);
        Root<Manufacturer> countRoot = countCriteriaQuery.from(Manufacturer.class);
        countCriteriaQuery.select(countCriteriaBuilder.count(countRoot));

        countCriteriaQuery.distinct(true);

        Join products = countRoot.join("products", JoinType.INNER);
        Join nickNames = products.join("nickNames", JoinType.INNER);


        Path expression = nickNames.get("id");
        Expression expression1 = (Expression<? extends Number>) expression;

        Number number = 1;

        Object value = (Object) number;

        Predicate gt = countCriteriaBuilder.gt(expression1, (Number) value);

        Predicate and = countCriteriaBuilder.and(gt);
        countCriteriaQuery.where(and);


        TypedQuery<Long> query = em.createQuery(countCriteriaQuery);
        System.out.println(query.getResultList().size());

        // erro que forca usar distinct quando nao e necesserio.
//        TypedQuery<Person> query = em.createQuery("select p from Person p left join p.dogs d where d.name = 'Fire'", Person.class);
//
//        System.err.println(query.getResultList().size());
//
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//
//        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
//        Root<Person> mainRoot = criteriaQuery.from(Person.class);
//        criteriaQuery.select(mainRoot);
//        mainRoot.join("dogs", JoinType.INNER);
//        Predicate predicate = criteriaBuilder.and(criteriaBuilder.equal(mainRoot.get("dogs").get("name"), "Fire"));
//        criteriaQuery.where(predicate);
//
//        TypedQuery<Person> criteriaGeneratedQuery = em.createQuery(criteriaQuery);
//        System.err.println(criteriaGeneratedQuery.getResultList()); // brings two objects instead one

//      Erro do hibernate caso a classe esteja long e n�o Long
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//		CriteriaQuery<Song> criteriaQuery = criteriaBuilder.createQuery(Song.class);
//		Root<Song> mainRoot = criteriaQuery.from(Song.class);
//		criteriaQuery.select(mainRoot);
//        Predicate predicate1 = criteriaBuilder.equal(mainRoot.get("totalDownloads").as(Long.class), 20L);
//        Predicate predicate2 = criteriaBuilder.equal(mainRoot.get("weight").as(Float.class), 10.00f);
//        Predicate firstOr = criteriaBuilder.or(predicate1, predicate2);
//
//        Predicate predicate3 = criteriaBuilder.equal(mainRoot.get("price").as(double.class), 20.00d);
//        Predicate predicate4 = criteriaBuilder.equal(mainRoot.get("type"), SongType.PRAISE);
//        Predicate secondOr = criteriaBuilder.or(predicate4, predicate3);
//
//        Predicate finalPredicate = criteriaBuilder.and(firstOr, secondOr);
//
//        criteriaQuery.where(finalPredicate);
//        TypedQuery<Song> criteriaGeneratedQuery = em.createQuery(criteriaQuery);
//        System.err.println(criteriaGeneratedQuery.getResultList());
        em.close();
        getEntityManagerFactory().close();
    }

//    protected static <T> List<T> getListFromJPQL(String query, Class<T> classToUse, Map<String, Object> parameters) {
//        EntityManager em = CodeGenerator.getEntityManager();
//
//        TypedQuery<T> typedQuery = em.createQuery(query, classToUse);
//
//        if (parameters != null) {
//            populateQueryParameters(typedQuery, parameters);
//        }
//
//        return typedQuery.getResultList();
//    }
//
//    private static <T> void populateQueryParameters(TypedQuery<T> query, Map<String, Object> parameters) {
//
//        for (Entry<String, Object> entry : parameters.entrySet()) {
//            query.setParameter(entry.getKey(), entry.getValue());
//        }
//    }

}