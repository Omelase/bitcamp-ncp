package bitcamp.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;

public class DaoGenerator implements InvocationHandler{

  SqlSessionFactory sqlSessionFactory;
  //  MyInvocationHandler InvocationHandler = new MyInvocationHandler();

  public DaoGenerator(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @SuppressWarnings("unchecked")
  public <T> T getObject(Class<T> classInfo) {

    String className = classInfo.getName();

    return (T) Proxy.newProxyInstance(
        getClass().getClassLoader(),
        new Class[] {classInfo},
        this  // InvocationHandler 객체
        );
  }



  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    String daoName = proxy.getClass().getInterfaces()[0].getSimpleName();
    // 1)      String proxyName = proxy.getClass().getName();
    String methodName = method.getName();
    String sqlStatementName = String.format("%s.%s", daoName, methodName);
    // 1)      System.out.printf("%s,%s 메서드 호출\n",proxyName, methodName);
    System.out.printf("%s,%s()  호출\n",daoName, methodName);

    Class<?> returnType = method.getReturnType();

    if (returnType == int.class || returnType == void.class) {
      return args == null ?
          sqlSession.insert(sqlStatementName) : sqlSession.insert(sqlStatementName, args[0]);
      // System.out.println(" => insert/update/delete 을 실행하는 메서드");
    } else if (returnType == List.class ) {
      return args == null ?
          sqlSession.selectList(sqlStatementName) : sqlSession.selectList(sqlStatementName, args[0]);
      // System.out.println(" => 0개 이상의 결과를 리턴하는 select를 실행하는 메서드");
    } else {
      return args == null ?
          sqlSession.selectOne(sqlStatementName) : sqlSession.selectOne(sqlStatementName, args[0]);
      // System.out.println(" = >0 또는 1개의 결과를 리턴하는 select 를 싱행하는 메서드");
    }
  }

  public static void main(String[] args) throws Exception {

    BitcampSqlSessionFactory sqlSessionFactory = new BitcampSqlSessionFactory(new SqlSessionFactoryBuilder().build(
        Resources.getResourceAsStream("bitcamp/myapp/config/mybatis-config.xml")));

    DaoGenerator generator = new DaoGenerator(sqlSessionFactory);
    BoardDao dao = generator.getObject(BoardDao.class);

    //    Board b = new Board();
    //    b.setTitle("테스트내용1");
    //    b.setContent("내용1");
    //    b.setPassword("1111");
    //
    //    dao.insert(b);

    List<Board> list =  dao.findAll();
    for (Board b : list) {
      System.out.println(b);
    }


    //    Board b = new Board();
    //    b.setNo(23);
    //    dao.findByNo(b);


    //    Board b = new Board();
    //    b.setNo(23);
    //    b.setTitle("테스트내용1");
    //    b.setContent("내용1");
    //    b.setPassword("1111");
    //    dao.update(b);


    //    Board b = new Board();
    //    b.setNo(23);
    //    dao.delete(1);

  }
}
