### @Component 已经可以支持声明一个 bean 了，为何还要再弄个 @Bean 出来？

Spring帮助我们管理Bean分为两个部分，一个是注册Bean，一个装配Bean。
完成这两个动作有三种方式，一种是使用自动配置的方式、一种是使用JavaConfig的方式，一种就是使用XML配置的方式。

1、@Compoent 作用就相当于 XML配置

2、@Bean 是一个方法级别上的注解，需要在配置类中使用，即类上需要加上@Configuration注解

如果你想要将第三方库中的组件装配到你的应用中，可是如果你没有源代码，也就无法在其上添加@Component，自动设置也就无从下手，在这种情况下，是没有办法在它的类上添加@Component注解的，因此就不能使用自动化装配的方案了，但是我们可以使用@Bean，@Bean会返回一个被spring认可的Bean。@Bean所注释的方法内部可以对这个第三方库的实例进行设置；
再进一步：@Bean可以灵活返回不同的Bean，假如有一个接口叫SomeService。Impl1, Impl2,Impl3和Impl4都继承自SomeService。
                        那么如下代码就可以根据状态变量，动态地返回不同的Bean。
                        
                        `java
                        @Bean
                         @Scope("prototype")
                         public SomeService someService() {
                             switch (state) {
                             case 1:
                                 return new Impl1();
                             case 2:
                                 return new Impl2();
                             case 3:
                                 return new Impl3();
                             default:
                                 return new Impl();
                             }
                         }
                         `