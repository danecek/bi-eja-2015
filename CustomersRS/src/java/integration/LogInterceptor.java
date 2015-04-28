/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author danecek
 */
@Interceptor
@LogInterceptorBinding
public class LogInterceptor {

    @AroundInvoke
    public Object invoke(InvocationContext ic) throws Exception {
        Logger.getAnonymousLogger().log(Level.INFO, ic.getMethod().getName());
        return ic.proceed();

    }

}
