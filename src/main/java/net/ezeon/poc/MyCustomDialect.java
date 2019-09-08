package net.ezeon.poc;

import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;
public class MyCustomDialect extends MySQL5Dialect {
    public MyCustomDialect() {
        super();
        this.registerFunction("group_concat", new SQLFunctionTemplate(StandardBasicTypes.STRING, "group_concat(?1)"));
    }
}
