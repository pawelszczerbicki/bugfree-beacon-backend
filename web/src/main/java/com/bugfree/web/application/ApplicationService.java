package com.bugfree.web.application;

import com.bugfree.commons.config.ConfigService;
import com.bugfree.web.amazon.S3Service;
import com.bugfree.web.customer.Customer;
import com.bugfree.web.customer.CustomerDao;
import com.bugfree.web.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.bugfree.commons.config.Keys.LOGO_BUCKET;

/**
 * Created by pawel on 20.09.15.
 */
@Service
public class ApplicationService {

    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private ColorSchemeDao colorSchemeDao;

    @Autowired
    private ConfigService config;

    public Application addShape(Shape s) {
        Customer c = service.get();
        return customerDao.save(c.withApplication(c.getApplication().withShape(s))).getApplication();
    }

    public Application addAppearance(Appearance a) {
        Customer c = service.get();
        return customerDao.save(c.withApplication(c.getApplication().withAppearance(a))).getApplication();
    }

    public Application addArrange(ArrangeType a) {
        Customer c = service.get();
        return customerDao.save(c.withApplication(c.getApplication().withArrangeType(a))).getApplication();
    }

    public Application addLogo(MultipartFile file) {
        Customer c = service.get();
        c.getApplication().setLogoUrl(s3Service.upload(file, c.getId(), config.get(LOGO_BUCKET)));
        return customerDao.save(c).getApplication();
    }

    public List<ColorScheme> getColorSchemes() {
        return colorSchemeDao.findAll();
    }

    public void save(ColorScheme scheme){
        colorSchemeDao.save(scheme);
    }
}
