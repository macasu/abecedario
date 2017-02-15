package abecedario.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SitemeshFilter extends ConfigurableSiteMeshFilter {
	@Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/autores", "/WEB-INF/decorators/tags.jsp")
        .addDecoratorPath("/", "/WEB-INF/decorators/tags.jsp")
        .addDecoratorPath("/login", "/WEB-INF/decorators/tags.jsp")
        .addDecoratorPath("/libros", "/WEB-INF/decorators/tags.jsp")
        .addDecoratorPath("/autor", "/WEB-INF/decorators/tags.jsp")
        .addExcludedPath("/excluded/*")
                .addExcludedPath("/resources/*").addExcludedPath("/decorators/*").addExcludedPath("/autores/*");
    }
}
