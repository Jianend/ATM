package mapper;
import org.apache.ibatis.annotations.Select;
import popj.Account;

import java.util.ArrayList;

public interface username {
    @Select("select * from tb_user where username=#{name}")
    int slsect(String name);
    @Select("select * from tb_user")
    Account[] add();

}
