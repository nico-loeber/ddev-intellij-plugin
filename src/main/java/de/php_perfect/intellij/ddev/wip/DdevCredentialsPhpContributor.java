package de.php_perfect.intellij.ddev.wip;

import com.intellij.docker.remote.DockerComposeCredentialsHolder;
import com.intellij.docker.remote.DockerComposeCredentialsType;
import com.intellij.docker.remote.DockerEditableCredentialsContribution;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.remote.CredentialsType;
import com.intellij.remote.ext.CredentialsLanguageContribution;
import com.jetbrains.php.config.phpInfo.PhpInfo;
import com.jetbrains.php.settingsSummary.util.PhpCredentialsContribution;
import com.jetbrains.php.settingsSummary.util.PhpSettingsCollector;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

public final class DdevCredentialsPhpContributor extends CredentialsLanguageContribution<PhpCredentialsContribution> implements PhpCredentialsContribution<DockerComposeCredentialsHolder>, DockerEditableCredentialsContribution {
    public CredentialsType getType() {
        return DdevCredentialsType.getInstance();
    }

    public Class<PhpCredentialsContribution> getLanguageContributionClass() {
        return PhpCredentialsContribution.class;
    }

    public PhpCredentialsContribution getLanguageContribution() {
        return this;
    }

    public String suggestName(final DockerComposeCredentialsHolder credentials, @Nullable final PhpInfo info) {
        return credentials.getComposeServiceName();
    }

    public void collectSettings(final DockerComposeCredentialsHolder cred, final StringBuilder output) {
        if (StringUtil.isNotEmpty(cred.getAccountName())) {
            PhpSettingsCollector.appendEntry("Docker Account Name", cred.getAccountName(), output);
        }
        PhpSettingsCollector.appendEntry("Docker Compose", String.valueOf(cred.getComposeFilePaths()), output);
        PhpSettingsCollector.appendEntry("Docker Service", cred.getComposeServiceName(), output);
    }

    @Nls
    public String validate(@Nullable final Project project, final DockerComposeCredentialsHolder credentials) {
        return null;
    }

    public String getConnectionPresentableName(final DockerComposeCredentialsHolder cred) {
        return "Ddev-nl-ck";
//        return invokedynamic(makeConcatWithConstants:(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;, cred.getComposeFilePaths(), cred.getComposeServiceName());
    }
}
