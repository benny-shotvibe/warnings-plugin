package hudson.plugins.warnings;

import hudson.model.AbstractBuild;

import hudson.plugins.analysis.core.HealthDescriptor;
import hudson.plugins.analysis.core.AbstractResultAction;
import hudson.plugins.analysis.core.PluginDescriptor;

/**
 * Aggregated warnings results. This action shows the results of all active parsers. Currently, the aggregated results
 * are not shown in the UI.
 *
 * @author Marvin Sch�tz
 * @author Sebastian Hansbauer
 */
public class AggregatedWarningsResultAction extends AbstractResultAction<AggregatedWarningsResult> {
    /**
     * Creates a new instance of <code>WarningsResultAction</code>.
     *
     * @param owner
     *            the associated build of this action
     * @param healthDescriptor
     *            health descriptor to use
     * @param result
     *            the result in this build
     */
    public AggregatedWarningsResultAction(final AbstractBuild<?, ?> owner, final HealthDescriptor healthDescriptor,
            final AggregatedWarningsResult result) {
        super(owner, new WarningsHealthDescriptor(healthDescriptor), result);
    }

    @Override
    public String getUrlName() {
        return WarningsDescriptor.RESULT_URL;
    }

    /** {@inheritDoc} */
    public String getDisplayName() {
        return Messages.Warnings_ProjectAction_Name();
    }

    /** {@inheritDoc} */
    @Override
    public String getIconFileName() {
        return null; // do not show aggregation in UI
    }

    @Override
    protected PluginDescriptor getDescriptor() {
        return new WarningsDescriptor();
    }
}
