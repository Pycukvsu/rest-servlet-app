package programm;

import dbutils.CRUDUtils;

import java.util.Scanner;

public class PlayerCreate {

    private static final Scanner scanner = new Scanner(System.in);

    public static Progresses[] createProgress(int playerId) {
        System.out.print("Введите размер массива Progress: ");
        int lProgress = scanner.nextInt();
        Progresses[] prog = new Progresses[lProgress];
        for (int i = 0; i < lProgress; i++) {
            System.out.print("Введите id для прогресса: ");
            int idProgress = scanner.nextInt();
            if (!CRUDUtils.searchId(idProgress, "SELECT id FROM progress")) {
                System.out.print("Введите resourceId: ");
                int resourceIdProgress = scanner.nextInt();
                System.out.print("Введите score: ");
                int scoreProgress = scanner.nextInt();
                System.out.print("Введите maxScore: ");
                int maxScoreProgress = scanner.nextInt();
                prog[i] = new Progresses(idProgress, playerId, resourceIdProgress, scoreProgress, maxScoreProgress);
            } else {
                System.out.println("Игрок с таким айди прогресса уже существует( \n" +
                        "Попробуйте ещё раз.");
                System.out.println();
                System.exit(0);
            }
        }
        return prog;
    }

    public static Progresses createUpdateProgress(int playerId) {
        Progresses progresses = null;
        System.out.print("Введите id: ");
        int idProgress = scanner.nextInt();
        if (!CRUDUtils.searchId(idProgress, "SELECT id FROM progress")) {
            System.out.print("Введите resourceId: ");
            int resourceIdProgress = scanner.nextInt();
            System.out.print("Введите score: ");
            int scoreProgress = scanner.nextInt();
            System.out.print("Введите maxScore: ");
            int maxScoreProgress = scanner.nextInt();
            progresses = new Progresses(idProgress, playerId, resourceIdProgress, scoreProgress, maxScoreProgress);
        } else {
            System.out.println("Игрок с таким айди прогресса уже существует( \n" +
                    "Попробуйте ещё раз.");
            System.out.println();
            System.exit(0);
        }
        return progresses;
    }

    public static Currencies[] createCurrencies(int playerId) {
        System.out.print("Введите размер массива Programm.Currencies: ");
        int lcurrencies = scanner.nextInt();
        Currencies[] curr = new Currencies[lcurrencies];
        for (int j = 0; j < lcurrencies; j++) {
            System.out.print("Введите id для валюты: ");
            int idCurr = scanner.nextInt();
            if (!CRUDUtils.searchId(idCurr, "SELECT id FROM currencies")) {
                System.out.print("Введите resourceId: ");
                int resourceIdCurr = scanner.nextInt();
                System.out.print("Введите name: ");
                String nameCurr = scanner.next();
                System.out.print("Введите count: ");
                int countCurr = scanner.nextInt();
                curr[j] = new Currencies(idCurr, playerId, resourceIdCurr, nameCurr, countCurr);
            } else {
                System.out.println("Игрок с таким айди валюты уже существует( \n" +
                        "Попробуйте ещё раз.");
                System.out.println();
                System.exit(0);
            }
        }
        return curr;
    }

    public static Currencies createUpdateCurrencies(int playerId) {
        Currencies currencies = null;
        System.out.print("Введите id: ");
        int idProgress = scanner.nextInt();
        if (!CRUDUtils.searchId(idProgress, "SELECT id FROM currencies")) {
            System.out.print("Введите resourceId: ");
            int resourceIdProgress = scanner.nextInt();
            System.out.print("Введите name: ");
            String name = scanner.next();
            System.out.print("Введите count: ");
            int count = scanner.nextInt();
            currencies = new Currencies(idProgress, playerId, resourceIdProgress, name, count);
        } else {
            System.out.println("Игрок с таким айди прогресса уже существует( \n" +
                    "Попробуйте ещё раз.");
            System.out.println();
            System.exit(0);
        }
        return currencies;
    }

    public static Items[] createItems(int playerId) {
        System.out.print("Введите размер массива Programm.Items: ");
        int lItems = scanner.nextInt();
        Items[] item = new Items[lItems];
        for (int k = 0; k < lItems; k++) {
            System.out.print("Введите id для предмета: ");
            int idItems = scanner.nextInt();
            if (!CRUDUtils.searchId(idItems, "SELECT id FROM items")) {
                System.out.print("Введите resourceId: ");
                int resourceIdItems = scanner.nextInt();
                System.out.print("Введите count: ");
                int countItems = scanner.nextInt();
                System.out.print("Введите level: ");
                int levelItems = scanner.nextInt();
                item[k] = new Items(idItems, playerId, resourceIdItems, countItems, levelItems);
            } else {
                System.out.println("Игрок с таким айди предмета уже существует( \n" +
                        "Попробуйте ещё раз.");
                System.out.println();
                System.exit(0);
            }
        }
        return item;
    }

    public static Items createUpdateItems(int playerId) {
        Items item = null;
        System.out.print("Введите id: ");
        int idProgress = scanner.nextInt();
        if (!CRUDUtils.searchId(idProgress, "SELECT id FROM items")) {
            System.out.print("Введите resourceId: ");
            int resourceIdProgress = scanner.nextInt();
            System.out.print("Введите count: ");
            int countItems = scanner.nextInt();
            System.out.print("Введите level: ");
            int levelProgress = scanner.nextInt();
            item = new Items(idProgress, playerId, resourceIdProgress, countItems, levelProgress);
        } else {
            System.out.println("Игрок с таким айди прогресса уже существует( \n" +
                    "Попробуйте ещё раз.");
            System.out.println();
            System.exit(0);
        }
        return item;
    }
}