package com.lee.learn.commons.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.SwitchTransformer;
import org.apache.commons.lang.StringUtils;

public class TransformDemo {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out.println(StringUtils.center("TransformerDemo", 40, "="));
		List<Applicant> applicantList 	= generateApplicantList();
		Predicate[] 	predicates 		= generatePredicateArray();
		Transformer[] 	transformers 	= generateTransformerArray();
		Transformer 	trans			= new SwitchTransformer(predicates, transformers, null);
		Collection<Employee> employed 	= CollectionUtils.collect(applicantList, trans);
		printApplicants(applicantList);
		printEmployees(employed);
		System.out.println(StringUtils.repeat("=", 40));
	}

	private static void printEmployees(Collection<Employee> employed) {
		System.out.println("print applicant employed employee::");
		for (Employee employee : employed) {
			System.out.println(employee);
		}
	}

	private static void printApplicants(List<Applicant> applicantList) {
		System.out.println("print applicant list:");
		for (Applicant applicant : applicantList) {
			System.out.println(applicant);
		}
	}

	private static Transformer[] generateTransformerArray() {
		Transformer developerTrans = new Transformer() {
			@Override
			public Object transform(Object input) {
				Applicant applicant = (Applicant)input;
				return new Employee(applicant.getName(), applicant.getAge(), new Date(), "E4", 4000);
			}
		};
		Transformer testerTrans = new Transformer() {
			@Override
			public Object transform(Object input) {
				Applicant applicant = (Applicant)input;
				return new Employee(applicant.getName(), applicant.getAge(), new Date(), "E4", 4000);
			}
		};
		Transformer pmTrans = new Transformer() {
			@Override
			public Object transform(Object input) {
				Applicant applicant = (Applicant)input;
				return new Employee(applicant.getName(), applicant.getAge(), new Date(), "E5", 6000);
			}
		};
		
		Transformer[] transformers = new Transformer[]{ developerTrans, testerTrans, pmTrans };
		return transformers;
	}

	private static Predicate[] generatePredicateArray() {
		Predicate isDeveloper = new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				Applicant applicant = (Applicant) object;
				return StringUtils.equalsIgnoreCase("developer",
						applicant.getApplyFor());
			}
		};
		Predicate isTester = new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				Applicant applicant = (Applicant) object;
				return StringUtils.equalsIgnoreCase("tester",
						applicant.getApplyFor());
			}
		};
		Predicate isPM = new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				Applicant applicant = (Applicant) object;
				return StringUtils.equalsIgnoreCase("project manager",
						applicant.getApplyFor());
			}
		};

		Predicate[] predicates = new Predicate[]{ isDeveloper, isTester, isPM };
		return predicates;
	}

	private static List<Applicant> generateApplicantList() {
		Applicant[] applicants = new Applicant[] {
				new Applicant("Tony", 26, "Developer"),
				new Applicant("Michelle", 24, "Tester"),
				new Applicant("Jack", 28, "Project Manager") };

		return Arrays.asList(applicants);
	}
}
