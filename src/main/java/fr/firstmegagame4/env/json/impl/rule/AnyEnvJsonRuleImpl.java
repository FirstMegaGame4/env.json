package fr.firstmegagame4.env.json.impl.rule;

import fr.firstmegagame4.env.json.api.EnvJsonVisitor;
import fr.firstmegagame4.env.json.api.rule.AnyEnvJsonRule;
import fr.firstmegagame4.env.json.api.rule.EnvJsonRule;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

@ApiStatus.Internal
public class AnyEnvJsonRuleImpl extends EnvJsonRuleImpl implements AnyEnvJsonRule {

	private final List<EnvJsonRule> rules;

	public AnyEnvJsonRuleImpl(List<EnvJsonRule> rules) {
		super(Type.ANY);
		this.rules = rules;
	}

	@Override
	public List<EnvJsonRule> rules() {
		return this.rules;
	}

	@Override
	public boolean apply(EnvJsonVisitor visitor) {
		for (EnvJsonRule rule : this.rules) {
			if (rule.apply(visitor)) {
				return true;
			}
		}
		return false;
	}
}
