package hello;

import com.slack.api.bolt.App;
import com.slack.api.model.event.AppMentionEvent;
import com.slack.api.model.event.MessageBotEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackApp {
    @Bean
    public App initSlackApp() {
        App app = new App();
        app.event(AppMentionEvent.class, (payload, ctx) -> {
            return ctx.ack();
        });
        app.event(MessageBotEvent.class, (payload, ctx) -> {
            return ctx.ack();
        });
        app.command("/do-the-thing", (req, ctx) -> {
            return ctx.ack("OK, let's do it!");
        });
        return app;
    }
}
