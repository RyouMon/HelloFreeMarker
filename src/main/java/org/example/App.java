package org.example;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Template;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException, TemplateException {
        // 1. Create a configuration instance
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setClassForTemplateLoading(App.class, "/templates");
        // recommend settings for new project
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
        cfg.setSQLDateAndTimeTimeZone(TimeZone.getDefault());

        // 2. Create a data-model
        Map<String, String> root = new HashMap<>();
        root.put("user", "world");

        // 3. Get the template
        Template template = cfg.getTemplate("hello.flth");

        // 4. Merging the template with the date-model
        Writer out = new OutputStreamWriter(System.out);
        template.process(root, out);
    }
}
