package config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by CoT on 10/14/17.
 */
@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan({"controller", "config", "service"})
@Import(SecurityConfig.class)
public class AppConfig {


    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

        Properties properties = new Properties();
        //For Postgresql
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        // For mysql
        // properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        // //For Azure
        // properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");

        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.hbm2ddl.auto", "create-drop");

        sessionFactoryBean.setPackagesToScan("model");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        
        //Local
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("tuan3112");

        //For Heroku
        // String dbUrl = System.getenv("JDBC_DATABASE_URL");
        // String username = System.getenv("JDBC_DATABASE_USERNAME");
        // String password = System.getenv("JDBC_DATABASE_PASSWORD");
        // dataSource.setUrl(dbUrl);
        // dataSource.setUsername(username);
        // dataSource.setPassword(password);

        //For Azure
        // dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // dataSource.setUrl("Server=tcp:sadihuy.database.windows.net,1433;Initial Catalog=sadi_huy;Persist Security Info=False;User ID=sadihuy;Password=Huy12345;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;");
        // dataSource.setUsername("sadihuy");
        // dataSource.setPassword("Huy12345");

        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setHibernateProperties(properties);

        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager tx = new HibernateTransactionManager(sessionFactory);

        return tx;
    }

}


