package studikasus.restfulapi.belajar

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import studikasus.restfulapi.belajar.resolver.UserArgumentResolver

@Configuration
class WebConfiguration (
    @Autowired
    val userArgumentResolver: UserArgumentResolver
): WebMvcConfigurer{

    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        resolvers.add(userArgumentResolver)
    }
}