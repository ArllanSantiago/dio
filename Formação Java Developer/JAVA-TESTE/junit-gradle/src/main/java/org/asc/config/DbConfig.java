package org.asc.config;

import java.util.logging.Logger;

public class DbConfig {
    private static final Logger logger = Logger.getLogger(DbConfig.class.getName());
    public static void inicializarConexao(){
        logger.info("Conexão Realtizada");
    }

    public static void finalizarConexao(){
        logger.info("Conexão Finalizada");
    }
}
