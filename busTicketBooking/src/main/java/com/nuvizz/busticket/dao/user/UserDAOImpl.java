package com.nuvizz.busticket.dao.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

import com.nuvizz.busticket.dto.OrderDTO;
import com.nuvizz.busticket.dto.ProviderDTO;
import com.nuvizz.busticket.dto.RoleDTO;
import com.nuvizz.busticket.dto.ServiceDTO;
import com.nuvizz.busticket.dto.UserDTO;

@Component
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = (Logger) LoggerFactory
			.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory factory;

	public List<String> fetchSource() {
		logger.info("Inside fetch source dao");

		List<String> list = null;
		ProviderDTO fromDB = null;
		Session session = null;
		try {
			session = factory.openSession();

			String s1 = "select distinct ser.source from ServiceDTO ser";
			Query q = session.createQuery(s1);
			list = q.list();

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("ending fetch source dao");

		return list;
	}

	public List<String> fetchDestination() {
		logger.info("Inside fetch destination dao");

		List<String> list = null;
		Session session = null;
		try {
			session = factory.openSession();

			String s1 = "select distinct ser.destination from ServiceDTO ser";
			Query q = session.createQuery(s1);
			list = q.list();

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("ending fetch destination dao");

		return list;
	}

	public List<ServiceDTO> searchBus(String source, String dest, Date d) {
		logger.info("Inside search bus dao");

		List<ServiceDTO> dtos = null;
		Session session = null;
		try {
			session = factory.openSession();
			System.out.println("sou" + source + "dest" + dest);
			/*
			 * SimpleDateFormat dt1 = new SimpleDateFormat("yyyy/mm/dd");
			 * //dt1.format(d); Calendar cal = Calendar.getInstance();
			 * cal.setTime(d); cal.add(Calendar.DATE, 1); Date d2 =
			 * cal.getTime(); String s1 =
			 * "select ser from ServiceDTO ser where ser.source=:source and ser.destination=:dest and ser.ddate between :d1 AND :d2"
			 * ; Query q = session.createQuery(s1); q.setParameter("source",
			 * source); q.setParameter("dest", dest); q.setParameter("d1",
			 * dt1.format(d)); q.setParameter("d2", d2);
			 */
			//System.out.println("d=" + d);
			Criteria cr = session.createCriteria(ServiceDTO.class);
			cr.add(Restrictions.eq("source", source));
			cr.add(Restrictions.eq("destination", dest));
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.DATE, 1);
			cr.add(Restrictions.ge("ddate", d));
			cr.add(Restrictions.lt("ddate", cal.getTime()));

			dtos = cr.list();

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("ending search bus dao");

		return dtos;
	}

	public int fetchSeats(int id) {
		logger.info("Inside fetch seat dao");

		int seat = 0;
		Session session = null;
		try {
			session = factory.openSession();

			String s1 = "select ser.seat from ServiceDTO ser where ser.id="
					+ id;
			Query q = session.createQuery(s1);
			seat = (Integer) q.uniqueResult();

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("ending fetch seat dao");

		return seat;
	}

	public boolean updateSeat(int seat, int id) {
		logger.info("Inside update seat dao");

		boolean res = false;
		Session session = null;
		try {
			session = factory.openSession();

			String s1 = "update ServiceDTO ser set ser.seat=:seat where ser.id=:id";
			Query q = session.createQuery(s1);
			q.setParameter("seat", seat);
			q.setParameter("id", id);
			q.executeUpdate();
			res = true;

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("ending fetch seat dao");

		return res;
	}

	public UserDTO getUserById(int id) {
		logger.info("Inside get user dao");

		UserDTO userDTO = null;
		Session session = null;
		try {
			session = factory.openSession();

			String s1 = "select user from UserDTO user where user.id=" + id;
			Query q = session.createQuery(s1);
			userDTO = (UserDTO) q.uniqueResult();

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("ending get user dao");

		return userDTO;

	}

	public boolean updateProfile(UserDTO dto) {
		logger.info("inside updateProfile dao");
		Session s = null;
		boolean res = false;
		Transaction t = null;
		try {

			if (dto != null) {
				s = factory.openSession();
				t = s.beginTransaction();
				RoleDTO roleDTO = s.get(RoleDTO.class, 2);
				Collection<RoleDTO> list = new ArrayList<RoleDTO>();
				list.add(roleDTO);
				dto.setRdtos(list);
				s.merge(dto);
				// s.saveOrUpdate(dto);
				res = true;
				t.commit();
			}

		} catch (HibernateException he) {
			t.rollback();
			System.err.println("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			s.close();
		}
		logger.info("exiting updateProfile dao");
		return res;
	}

	public List<ServiceDTO> sorting(String src, String dest, Date date) {
		logger.info("Inside sorting dao");

		List<ServiceDTO> list = null;
		Session session = null;
		try {
			session = factory.openSession();

			Criteria cr = session.createCriteria(ServiceDTO.class);
			cr.add(Restrictions.eq("source", src));
			cr.add(Restrictions.eq("destination", dest));
			cr.addOrder(Order.asc("departure"));
			/*
			 * String s1 =
			 * "select ser from ServiceDTO ser where ser.source=:src and ser.destination=:dest order by ser.departure"
			 * ; Query q = session.createQuery(s1); q.setParameter("src", src);
			 * q.setParameter("dest", dest);
			 */
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			cr.add(Restrictions.ge("ddate", date));
			cr.add(Restrictions.lt("ddate", cal.getTime()));

			list = cr.list();

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("ending search bus dao");

		return list;
	}

	public boolean saveOrder(OrderDTO dto) {
		logger.info("Starting save order DAO");
		boolean res = false;
		if (dto != null) {

			Session s = null;
			Transaction t = null;

			try {
				s = factory.openSession();
				t = s.beginTransaction();
				s.save(dto);
				t.commit();
				res = true;
			} catch (HibernateException he) {
				t.rollback();
				logger.error("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				s.close();
			}

		}

		logger.info("Ending save order DAO");
		return res;
	}

	public List<OrderDTO> fetchOrderByName(String name) {
		logger.info("Inside fetch order by name dao");

		List<OrderDTO> dtos = null;
		Session session = null;
		try {
			session = factory.openSession();

			String s1 = "select o from OrderDTO o where o.username=:name";
			Query q = session.createQuery(s1);
			q.setParameter("name", name);
			dtos = q.list();

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("ending fetch order by name dao");

		return dtos;
	}

	public String sendUserId(String email) {

		logger.info("Inside forgot userid dao");

		String emailFromDB = null;

		if (email != null) {
			Session session = null;
			try {
				session = factory.openSession();

				String s1 = "select user.username from UserDTO user where user.email=:email";
				Query q = session.createQuery(s1);
				q.setParameter("email", email);
				emailFromDB = (String) q.uniqueResult();
				logger.info(emailFromDB);

			} catch (HibernateException he) {
				logger.error("Exception " + he.getMessage());
				he.printStackTrace();
			} finally {
				session.close();
			}
		}
		logger.info("exiting forgot id dao");

		return emailFromDB;

	}

	public boolean changePassword(String email, String pass, String cpass) {
		logger.info("Inside change password dao");

		int res = 0;
		boolean result = false;
		Session session = null;
		Transaction tx = null;
		if (email != null) {

			if (pass.equals(cpass)) {

				try {
					session = factory.openSession();
					tx = session.beginTransaction();
					// String encryptPass = AESCrypt.encrypt(pass);
					// String encryptCpass = AESCrypt.encrypt(cpass);
					String s1 = "update UserDTO u set u.password=?,u.cpass=? where u.email='"
							+ email + "'";
					Query q = session.createQuery(s1);
					q.setParameter(0, pass);
					q.setParameter(1, cpass);
					res = q.executeUpdate();
					tx.commit();
					if (res == 1)
						result = true;

				} catch (HibernateException he) {
					logger.error("Exception " + he.getMessage());
					tx.rollback();
					he.printStackTrace();
				} finally {
					session.close();
				}

			}
		}

		logger.info("exiting change password dao");

		return result;

	}

	public UserDTO checkEmail(String email) {
		logger.info("Inside get email dao");

		UserDTO userDTO = null;
		Session session = null;
		try {
			session = factory.openSession();

			String s1 = "select user from UserDTO user where user.email='"
					+ email + "'";
			Query q = session.createQuery(s1);
			userDTO = (UserDTO) q.uniqueResult();

		} catch (HibernateException he) {
			logger.error("Exception " + he.getMessage());
			he.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("ending get user dao");

		return userDTO;

	}

}
