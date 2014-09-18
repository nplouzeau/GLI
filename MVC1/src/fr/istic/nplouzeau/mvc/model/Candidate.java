package fr.istic.nplouzeau.mvc.model;

import com.sun.istack.internal.NotNull;

/**
 * Created by plouzeau on 2014-09-18.
 */
public final class Candidate {

    public static class CandidateBuilder {

        private String name;
        private String emailAddress;

        public CandidateBuilder name(@NotNull String name) {
            if(name == null) {
                throw new IllegalArgumentException("name is null");
            }
            this.name = name;
            return this;
        }

        public CandidateBuilder emailAddress(@NotNull String emailAddress) {
            if (emailAddress == null) {
                throw new IllegalArgumentException("email address is null");
            }
            this.emailAddress = emailAddress;
            return this;
        }

        public Candidate build() {

            if(name.length() == 0) {
                throw new IllegalArgumentException("name cannot be empty");
            }
            Candidate newCandidate = new Candidate();
            newCandidate.name = name;
            newCandidate.emailAddress = emailAddress;
            return newCandidate;
        }

        private CandidateBuilder() {}
    }

    private Candidate() {
    }

    public static CandidateBuilder GetBuilder() {
        return new CandidateBuilder();
    }

    public String getName() {
        return name;
    }

    private String name;

    public String getEmailAddress() {
        return emailAddress;
    }

    private String emailAddress;

}
