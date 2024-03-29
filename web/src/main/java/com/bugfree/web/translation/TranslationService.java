package com.bugfree.web.translation;

import com.bugfree.web.utils.DomainProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by pawel on 21.09.15.
 */
@Service
public class TranslationService {

    @Autowired
    private DomainProvider provider;

    @Autowired
    private TranslationDao dao;

    public Translation save(Translation t) {
        t.setDomain(provider.getDomain());
        return dao.save(t);
    }

    public List<Translation> getAll() {
        return dao.findByDomain(provider.getDomain());
    }

    public List<String> getAllLanguages() {
        return dao.findLangByDomain(provider.getDomain()).stream().map(Translation::getLanguageCode).collect(toList());
    }
}
