package org.example.AtmSystem.model.queries;

public class AccountQuery {
    public static final String CREATE_TABLE = """
            create table if not exists tb_account(
            id bigserial primary key,
            accountNumber varchar(50),
            pin int ,
            balance double,
            foreign key id references tb_user(id)
            )
            """;

    public final static String SAVE_QUERY = """
            insert into tb_account(
            accountNumber,
            pin,
            balance)
                        
                      
            values(?,?,?,?,?,?,?,?)
            """;

    public final static String UPDATE_QUERY = """
            update tb_account
              set accountNumber=?,
                   pin=?,
                   balance=?
             where id=?

            """;
    public final static String DELETE_QUERY = """
            delete
            from tb_account
            where id=?
            """;

    public final static String FIND_BY_ID_QUERY = """
            select *
            from tb_account
            where id=?
            """;
    public final static String FIND_ALL_QUERY = """
            select * 
            from tb_account
            where id=?
            """;


}


