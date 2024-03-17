package org.asc;

import org.asc.facade.ClientMigration;
import org.asc.facade.Facade;
import org.asc.facade.MigrationService;
import org.asc.singleton.SingletonEager;
import org.asc.singleton.SingletonLazy;
import org.asc.singleton.SingletonLazyHolder;
import org.asc.strategy.*;

import java.util.logging.Logger;


public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static void equalsObj(Object objFierst , Object objLast){
        var condition = objFierst.equals(objLast)? "igual a":"diferente de";
        System.out.println(String.format("O primerio Obj:%s é %s Obj:%s",objFierst,condition,objLast));
    }
    public static void main(String[] args) {
        //Singleton
        logger.info("[Singleton] Apressado / Preguiçoso / Titular Preguiçoso");
        equalsObj(SingletonEager.getInstance(), SingletonEager.getInstance());
        equalsObj(SingletonLazy.getInstance(), SingletonLazy.getInstance());
        equalsObj(SingletonLazyHolder.getInstance(),SingletonLazyHolder.getInstance());

        //Strategy
        logger.info("[Strategy]");
        final BehaviorNormal comportamentoNormal = new BehaviorNormal();
        final BehaviorDefensive comportamentoDefensivo = new BehaviorDefensive();
        final BehaviorAggressive comportamentoAgressivo = new BehaviorAggressive();
        final Robot robot = new Robot();

        robot.setComportamento(comportamentoNormal);
        robot.mover();
        robot.setComportamento(comportamentoDefensivo);
        robot.mover();
        robot.setComportamento(comportamentoAgressivo);
        robot.mover();

        //Facade
        Facade facade = new Facade();
        ClientMigration facadeClientMigration = facade.getClientMigration("Arllan","50710390");

        MigrationService migrationService = MigrationService.getInstance();

        migrationService.save(facadeClientMigration);


    }
}