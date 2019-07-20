缓存 spring caching 与 ehcache 的学习

总概括====================================
https://elim.iteye.com/blog/2123030
https://www.cnblogs.com/jianjianyang/p/4933016.html

spring自带缓存caching ===================================
https://elim.iteye.com/blog/2123030

1、配置缓存管理器
	 xmlns:cache="http://www.springframework.org/schema/cache"
	 xmlns:p="http://www.springframework.org/schema/p"【其没有对应xsd 同时引入该命名空间后 才可以使用p:name 等方式进行属性的命名】
	 
	 http://www.springframework.org/schema/cache
     http://www.springframework.org/schema/cache/spring-cache-4.0.xsd

	 托管cacheManager
	 <cache:annotation-driven cache-manager="cacheManager"/>
   	
     <bean id="cacheManager" class="org.springframework.cache.support.SimpleCacheManager">
    	<property name="caches">
    		<set>
    			<bean class="org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean"   p:name="default"></bean>
    			<bean class="org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean"   p:name="student"></bean>
    		</set>
    	</property>
     </bean>
     
2、使用 @Cachable @Caching @CacheEvict 可用于类注解也可用于方法注解
	需注意：同类之间调用时 缓存功能不生效
	
	@Cachable(value="cacheName",key="key值有默认值也可自定义",condition="springel表达式,当返回true执行缓存，若返回false则不执行")
	@CacheEvict(value="同上",key="同上",condition="同上",allEntriet="默认为false，当为true时表示缓存全部清空",beforeInvocation="设置为true表示在当前方法执行之前执行该清除工作，因为默认情况下该清除工作要在当前方法执行完毕后执行成功进行执行。")
	@Caching 可混合使用上面两个注解