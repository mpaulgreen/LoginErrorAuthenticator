package mpaulgreen.keycloak.authenticator;

import org.jboss.logging.Logger;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.Authenticator;
import org.keycloak.forms.login.LoginFormsProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

import javax.ws.rs.core.Response;
import java.util.function.Consumer;

public class LoginErrorAuthenticator implements Authenticator {
    private static final Logger logger = Logger.getLogger(LoginErrorAuthenticator.class);

    @Override
    public void authenticate(AuthenticationFlowContext context) {
        System.out.println("Authenticate method called");
        context.challenge(createForm(context, null));
    }

    @Override
    public void action(AuthenticationFlowContext context) {
    }

    @Override
    public boolean requiresUser() {
        return false;
    }

    @Override
    public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) {
        return false;
    }

    @Override
    public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {

    }

    @Override
    public void close() {

    }

    private Response createForm(AuthenticationFlowContext context, Consumer<LoginFormsProvider> formConsumer) {
        System.out.println("createForm called");
        LoginFormsProvider form = context.form();
        return form.createForm("loginerror.ftl");
    }

}
