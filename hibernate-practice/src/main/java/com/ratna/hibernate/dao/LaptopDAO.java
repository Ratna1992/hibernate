package com.ratna.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ratna.hibernate.pojo.Laptop;

@SuppressWarnings("deprecation")
public class LaptopDAO {

	@SuppressWarnings("unchecked")
	public static List<Laptop> getAllLaptops(Session session, String query) {
		Query<Laptop> reqList = session.createQuery(query);
		return reqList.list();

	}

	@SuppressWarnings("unchecked")
	public static Laptop getRequiredLaptop(Session session, String query) {
		Query<Laptop> reqLaptop = session.createQuery(query);
		return reqLaptop.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public static Object[] getRequiredData(Session session, String query) {
		Query<Object[]> reqData = session.createQuery(query);
		return reqData.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public static List<Object[]> getRequiredDataList(Session session, String query) {
		Query<Object[]> reqList = session.createQuery(query);
		return reqList.list();

	}

	@SuppressWarnings("unchecked")
	public static Double getTotals(Session session, String query) {
		Query<Double> reqData = session.createQuery(query);
		return reqData.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public static Double getTotalsUsingPositionalParameters(Session session, String query, double b) {
		Query<Double> reqData = session.createQuery(query);
		reqData.setParameter("b", b);
		return reqData.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public static List<Laptop> getAllLaptopsPagination(Session session, String query) {
		Query<Laptop> reqList = session.createQuery(query);
		reqList.setFirstResult(1);
		reqList.setMaxResults(5);
		return reqList.list();

	}

	@SuppressWarnings("unchecked")
	public static int updateLaptop(Session session, String query, double price, String brand) {
		Query<Double> reqData = session.createQuery(query);
		reqData.setParameter("price", price);
		reqData.setParameter("brand", brand);
		return reqData.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public static int deleteLaptop(Session session, String query, String brand) {
		Query<Double> reqData = session.createQuery(query);
		reqData.setParameter("brand", brand);
		return reqData.executeUpdate();
	}

	@SuppressWarnings({ "unchecked" })
	public static List<Laptop> getListAsNativeSQL(Session session, String query) {
		SQLQuery<Laptop> reqList = session.createSQLQuery(query);
		reqList.addEntity(Laptop.class);
		return reqList.list();

	}

	@SuppressWarnings({  "rawtypes" })
	public static List getRequiredFieldListAsNativeSQL(Session session, String query) {
		SQLQuery reqList = session.createSQLQuery(query);
		reqList.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		return reqList.list();

	}

}
