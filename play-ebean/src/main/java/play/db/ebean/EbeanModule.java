/*
 * Copyright (C) 2009-2014 Typesafe Inc. <http://www.typesafe.com>
 */
package play.db.ebean;

import play.api.Configuration;
import play.api.Environment;
import play.api.db.evolutions.DynamicEvolutions;
import play.api.inject.Binding;
import play.api.inject.Module;
import scala.collection.Seq;

import javax.inject.Singleton;

/**
 * Injection module with default Ebean components.
 */
public class EbeanModule extends Module {

    @Override
    public Seq<Binding<?>> bindings(Environment environment, Configuration configuration) {
        return seq(
            bind(DynamicEvolutions.class).to(EbeanDynamicEvolutions.class).eagerly(),
            bind(EbeanConfig.class).toProvider(DefaultEbeanConfig.EbeanConfigParser.class).eagerly()
        );
    }

}
