package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Guerrero;
import entities.VehiculoGuerra;
import interfaces.VehiculoGuerraDAO;
import utils.Utils;

public class VehiculoGuerraDAOImpl implements VehiculoGuerraDAO {

	private Session session;

	@Override
	public void insertVehiculoGuerra(VehiculoGuerra vehiculo) {

		session = Utils.getSession();
		
		Transaction tx = session.beginTransaction();
		session.persist(vehiculo);
		tx.commit();
	}

	@Override
	public void insertGuerrero(Guerrero guerrero) {
		
	}
}
