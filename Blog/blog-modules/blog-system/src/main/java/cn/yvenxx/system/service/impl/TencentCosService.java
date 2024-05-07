package cn.yvenxx.system.service.impl;

import cn.yvenxx.common.util.R;
import cn.yvenxx.system.mapper.TUserMapper;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Calendar;

@Service
public class TencentCosService {
    @Value("${spring.tencent.secretId}")
    private String secretId;
    @Value("${spring.tencent.secretKey}")
    private String secretKey;
    @Value("${spring.tencent.region}")
    private String region;
    @Value("${spring.tencent.bucketName}")
    private String bucketName;
    @Value("${spring.tencent.url}")
    private String url;
    @Value("${spring.tencent.path}")
    private String path;

    @Autowired
    private TUserMapper tUserMapper;

    public String uploadFile(MultipartFile file) {
        if (file == null){
            return null;
        }
        String oldFileName = file.getOriginalFilename();
        String newFileName = System.currentTimeMillis() + oldFileName.substring(oldFileName.lastIndexOf("."));
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        BasicCOSCredentials credentials = new BasicCOSCredentials(secretId, secretKey);
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        COSClient cosClient = new COSClient(credentials, clientConfig);
        String bucketName = this.bucketName;
        try {
            cosClient.putObject(bucketName, path + "/" + year + "/" + month + "/" + newFileName, file.getInputStream(), null);
            return url + "/" + path + "/" + year + "/" + month + "/" + newFileName;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cosClient.shutdown();
        }
        return null;
    }


}
