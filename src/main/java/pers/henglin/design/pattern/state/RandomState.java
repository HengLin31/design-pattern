package pers.henglin.design.pattern.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomState {
    private static final Logger LOG = LoggerFactory.getLogger(RandomState.class);
    /*
        [create] --> [ready] <--> [running] --> [finish]
                     ^           |
                     |           V
                     [  blocked  ]
     */
    public static void main(String[] args){
        //if (null == actions) then use random
        ThreadContext context = new ThreadContext(null);
        while(!context.isFinish()){
            context.change();
        }
        LOG.info(context.getLog());
    }
}
