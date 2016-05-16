package fr.config;

/**
 * Application constants.
 */
public final class Constants {

    // Spring profile for development and production, see http://jhipster.github.io/profiles/
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";

    // Spring profile used to disable running liquibase
    public static final String SPRING_PROFILE_NO_LIQUIBASE = "no-liquibase";
    

    public static final String SYSTEM_ACCOUNT = "system";

    private Constants() {
    }
}
