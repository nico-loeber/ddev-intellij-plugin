//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package de.php_perfect.intellij.ddev.wip;

import com.intellij.docker.i18n.DockerBundle;
import com.intellij.docker.remote.DockerComposeCredentialsEditor;
import com.intellij.docker.remote.DockerComposeCredentialsHandler;
import com.intellij.docker.remote.DockerComposeCredentialsHolder;
import com.intellij.docker.remote.DockerComposeCredentialsType;
import com.intellij.docker.remote.DockerEditableCredentialsContribution;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.remote.CredentialsType;
import com.intellij.remote.ext.CredentialsEditor;
import com.intellij.remote.ext.CredentialsLanguageContribution;
import com.intellij.remote.ext.RemoteCredentialsHandler;
import com.intellij.remote.ui.BundleAccessor;
import com.intellij.remote.ui.CredentialsEditorProvider;
import com.intellij.remote.ui.RemoteSdkEditorForm;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DdevCredentialsType extends CredentialsType<DockerComposeCredentialsHolder> implements CredentialsEditorProvider {
    @NonNls
    public static final String DOCKER_COMPOSE_PREFIX = "docker-compose://";
    public static final Key<DockerComposeCredentialsHolder> DOCKER_COMPOSE_CREDENTIALS = Key.create("DOCKER_COMPOSE_CREDENTIALS");

    @NotNull
    public static DdevCredentialsType getInstance() {
        final DdevCredentialsType dockerComposeCredentialsType = (DdevCredentialsType) CredentialsType.EP_NAME.findExtensionOrFail((Class) DdevCredentialsType.class);
        if (dockerComposeCredentialsType == null) {
            $$$reportNull$$$0(0);
        }

        return dockerComposeCredentialsType;
    }

    public DdevCredentialsType() {
        super(DockerBundle.message("DockerComposeCredentialsType.name"), "docker-compose://");
    }

    public Key<DockerComposeCredentialsHolder> getCredentialsKey() {
        return DOCKER_COMPOSE_CREDENTIALS;
    }

    public RemoteCredentialsHandler getHandler(DockerComposeCredentialsHolder credentials) {
        return new DockerComposeCredentialsHandler(credentials);
    }

    public DockerComposeCredentialsHolder createCredentials() {
        return new DockerComposeCredentialsHolder();
    }

    public boolean isAvailable(CredentialsLanguageContribution languageContribution) {
        return languageContribution instanceof DockerEditableCredentialsContribution;
    }

    public CredentialsEditor createEditor(@Nullable final Project project, final CredentialsLanguageContribution languageContribution, @NotNull final RemoteSdkEditorForm parentForm) {
        if (parentForm == null) {
            $$$reportNull$$$0(1);
        }

        return new DockerComposeCredentialsEditor(project, null, (CredentialsLanguageContribution<?>) languageContribution, parentForm.getStatusPanel());
    }

    public String getDefaultInterpreterPath(BundleAccessor bundleAccessor) {
        return bundleAccessor.message("remote.interpreter.docker.default.interpreter.path");
    }

    public int getWeight() {
        return 30;
    }

    private static /* synthetic */ void $$$reportNull$$$0(final int n) {
        String format = null;
        switch (n) {
            default: {
                format = "@NotNull method %s.%s must not return null";
                break;
            }
            case 1: {
                format = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            }
        }

        int n2 = 0;
        switch (n) {
            default: {
                n2 = 2;
                break;
            }
            case 1: {
                n2 = 3;
                break;
            }
        }

        final Object[] args = new Object[n2];
        switch (n) {
            default: {
                args[0] = "com/intellij/docker/remote/DockerComposeCredentialsType";
                break;
            }
            case 1: {
                args[0] = "parentForm";
                break;
            }
        }

        switch (n) {
            default: {
                args[1] = "getInstance";
                break;
            }
            case 1: {
                args[1] = "com/intellij/docker/remote/DockerComposeCredentialsType";
                break;
            }
        }

        switch (n) {
            case 1: {
                args[2] = "createEditor";
                break;
            }
        }

        final String format2 = String.format(format, args);
        RuntimeException ex = null;
        switch (n) {
            default: {
                ex = new IllegalStateException(format2);
                break;
            }
            case 1: {
                ex = new IllegalArgumentException(format2);
                break;
            }
        }

        throw ex;
    }
}
