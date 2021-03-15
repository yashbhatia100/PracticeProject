/*
 * package com.cg.apps.customerms.items.dao;
 * 
 * import java.util.Random;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.PersistenceContext; import javax.transaction.Transactional;
 * 
 * 
 * import org.springframework.stereotype.Repository;
 * 
 * import com.cg.apps.customerms.items.entities.Item;
 * 
 * @Repository public class ItemDaoImpl implements IItemDao {
 * 
 * @PersistenceContext private EntityManager entityManager;
 * 
 * 
 * 
 * public String generateString() { String str="Item"; StringBuilder builder =
 * new StringBuilder(); for(int i=0;i<3;i++) { Random random=new Random(); int
 * generateid=random.nextInt(9); builder.append(generateid); } String
 * itemid=builder.toString(); return str+itemid;
 * 
 * }
 * 
 * @Transactional
 * 
 * @Override public Item add(Item item) { String id=generateString();
 * item.setId(id); entityManager.persist(item);
 * 
 * return item; }
 * 
 * @Override public Item update(Item item) {
 * 
 * 
 * return entityManager.merge(item); }
 * 
 * @Override public Item findByID(String ItemID) { Item item =
 * entityManager.find(Item.class,ItemID); return item; }
 * 
 * 
 * 
 * }
 */