package com.gw.examples.hello;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.io.File;

import static org.fest.assertions.Assertions.assertThat;
import static org.jboss.shrinkwrap.api.ShrinkWrap.create;

@RunWith(Arquillian.class)
public class HelloServiceImplTest {

    @Inject
    private HelloService helloService;

    @Deployment
    public static Archive<?> deployment() {
        final File[] files = Maven.resolver().loadPomFromFile("pom.xml").resolve("org.easytesting:fest-assert").
                withTransitivity().asFile();
        return create(WebArchive.class).addClasses(HelloService.class, HelloServiceImpl.class).addAsLibraries(files);
    }

    @Test
    public void shouldSayHelloToJohn() throws Exception {
        final String name = "John";

        final String message = helloService.sayHello(name);

        assertThat(message).isEqualTo("Hello John!");
    }
}
