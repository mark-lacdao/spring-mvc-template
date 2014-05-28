package org.nerv.boilingriver.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by mark.lacdao on 28/05/2014.
 */
@Service
public class SampleService {

    public String reverse(String text){
        return StringUtils.reverse(text);
    }

}
