import mapper.username;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import popj.Account;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class user {
    static ArrayList<Account> usernames(ArrayList<Account> accounts) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        username mapper = sqlSession.getMapper(username.class);
        int lisi = mapper.slsect("lisi");
        System.out.println(lisi);
        Account[] add = mapper.add();
        for (int i = 0; i < add.length; i++) {

            accounts.add(add[i]);

        }
        return accounts;
    }
}
