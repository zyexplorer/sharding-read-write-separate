package com.zy.shardingreadwriteseparate.config;

import com.dangdang.ddframe.rdb.sharding.api.MasterSlaveDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.strategy.slave.MasterSlaveLoadBalanceStrategyType;
import com.dangdang.ddframe.rdb.sharding.keygen.DefaultKeyGenerator;
import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//import io.shardingsphere.core.keygen.DefaultKeyGenerator;
//import io.shardingsphere.core.keygen.KeyGenerator;
//import io.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;

/**
 * @author ZY
 */
@Configuration
public class DataSourceConfig {

    @Resource
    private MasterConfig masterConfig;

    @Resource
    private Slave1Config slave1Config;

    @Resource
    private Slave2Config slave2Config;

    @Bean
    public DataSource getDataSource() throws SQLException {
        return buildDataSource();
    }

    private DataSource buildDataSource() throws SQLException {
        //设置从库数据源集合
        Map<String, DataSource> slaveDataSourceMap = new HashMap<>();
        slaveDataSourceMap.put(slave1Config.getDatabaseName(), slave1Config.createDataSource());
        slaveDataSourceMap.put(slave2Config.getDatabaseName(), slave2Config.createDataSource());

        //获取数据源对象
        return MasterSlaveDataSourceFactory.createDataSource("masterSlave",
                masterConfig.getDatabaseName(), masterConfig.createDataSource(),
                slaveDataSourceMap, MasterSlaveLoadBalanceStrategyType.getDefaultStrategyType());
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new DefaultKeyGenerator();
    }

}
