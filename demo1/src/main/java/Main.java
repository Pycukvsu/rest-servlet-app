
import programm.JsonUpdate;
import programm.Player;
import dbutils.CRUDUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("/Users/sandra/IdeaProjects/demo1/players.json");
        Player[] players = (objectMapper.readValue(file, Player[].class));
        CRUDUtils.savePlayer(players);
        JsonUpdate.ReadToMap(players);

        int reboot = 0;
        while (reboot != 4) {
            System.out.println();
            System.out.println("Что хотите сделать?");
            System.out.println("1 - Добавить игрока | 2 - Удалить игрока | 3 - Изменить данные игрока | - 4 Остановить программу");
            int a = scanner().nextInt();

            HashMap<Integer, Player> playerHashMap;
            if (a == 1) {
                Player player = CRUDUtils.addPlayer();
                JsonUpdate.addPlayerInMap(player);

                System.out.println("Данные из БД: ");
                playerHashMap = CRUDUtils.getPlayerData();
                System.out.println(playerHashMap.get(player.getPlayerId()));
            } else if (a == 2) {
                int playerId = CRUDUtils.deletePlayer();
                JsonUpdate.deletePlayerFromMap(playerId);

                System.out.println("Данные из БД: ");
                System.out.println("Если вывело false, то игрок успешно удалён из БД");
                playerHashMap = CRUDUtils.getPlayerData();
                System.out.println(playerHashMap.containsKey(playerId));
            } else if (a == 3) {
                int playerId = CRUDUtils.updatePlayer();

                System.out.println("Данные из БД: ");
                playerHashMap = CRUDUtils.getPlayerData();
                System.out.println(playerHashMap.get(playerId));
            }else {
                reboot = 4;
            }
            //Programm.JsonUpdate.JsonInFile(new File("C:/Users/User/Documents/lab2crudbd-main/untitled9/players.json"), objectMapper);
        }
    }

    public static Scanner scanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
}