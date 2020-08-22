package top.krasus1966.fastdfs;

import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 基于fastdfs-client-java 1.29-SNAPSHOT
 *
 * @author Krasus1966
 * @date 2020/8/18 21:39
 **/
@Configuration
@ConditionalOnClass(value = {StorageClient.class, StorageServer.class})
@EnableConfigurationProperties(FastProperties.class)
public class AutoConfigFastDFS {
    @Resource
    private FastProperties fastProperties;

    @Bean
    public FastDFSClient fastDFSClient() throws Exception {
        return new FastDFSClient(fastProperties);
    }
}
