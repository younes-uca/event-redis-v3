package ma.sir.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.sir.event.bean.core.BlocOperatoir;
import ma.sir.event.bean.core.EvenementState;
import ma.sir.event.bean.core.Salle;
import ma.sir.event.service.facade.admin.BlocOperatoirAdminService;
import ma.sir.event.service.facade.admin.EvenementStateAdminService;
import ma.sir.event.service.facade.admin.SalleAdminService;
import ma.sir.event.zynerator.security.bean.Permission;
import ma.sir.event.zynerator.security.bean.Role;
import ma.sir.event.zynerator.security.bean.User;
import ma.sir.event.zynerator.security.common.AuthoritiesConstants;
import ma.sir.event.zynerator.security.service.facade.RoleService;
import ma.sir.event.zynerator.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableCaching
//@EnableFeignClients("ma.sir.event.required.facade")
public class EventApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(EventApplication.class, args);
        //constructData();
    }


    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
        return (args) -> {
            if (false) {

                createEvenementState();
                createBlocOperatoir();
                createSalle();


                // Role admin

                User userForAdmin = new User("admin");

                Role roleForAdmin = new Role();
                roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
                List<Permission> permissionsForAdmin = new ArrayList<>();
                addPermissionForAdmin(permissionsForAdmin);
                roleForAdmin.setPermissions(permissionsForAdmin);
                if (userForAdmin.getRoles() == null)
                    userForAdmin.setRoles(new ArrayList<>());

                userForAdmin.getRoles().add(roleForAdmin);
                userService.save(userForAdmin);
            }
        };
    }


    private void createEvenementState() {
        String reference = "reference";
        String code = "code";
        List<String> status = Arrays.asList("programmer", "en cours", "cloturer");
        for (int i = 0; i < status.size(); i++) {
            EvenementState item = new EvenementState();
            item.setReference(status.get(i));
            item.setCode(status.get(i));
            evenementStateService.create(item);
        }
    }

    private void createSalle() {
        String reference = "salle";
        String code = "salle";
        for (int i = 1; i < 11; i++) {
            Salle item = new Salle();
            item.setReference(fakeString(reference, i));
            item.setCode(fakeString(code, i));
//            item.setBlocOperatoir(blocOperatoirService.findById(i % 2 + 1L));
            salleService.create(item);
        }
    }

    private void createBlocOperatoir() {
        String reference = "blocOp";
        String code = "blocOp";
        for (int i = 1; i < 5; i++) {
            BlocOperatoir item = new BlocOperatoir();
            item.setReference(fakeString(reference, i));
            item.setCode(fakeString(code, i));
            blocOperatoirService.create(item);
        }
    }

    private static String constructDescription(int i) {
        String description = "desc " + ((i % 10) + 1);
        return " \"description\": \"" + description + "\" ";
    }


    private static String constructReference(int i) {
        String evenement = "EV-" + ((i % 100) + 1);
        String salle = "_S-" + (i % 30);
        String blocOperatoir = "_B-" + ((i % 10) + 1);
        String date = "_" + constructDate();
        return " \"reference\": \"" + evenement + salle + blocOperatoir + date + "\" ";
    }

    private static String constructDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return now.format(formatter);
    }

    public static String constructData() {
        String res = "";
        int lastElement = 1876;
        for (int i = 1; i <= lastElement; i++) {
            String reference = constructReference(i);
            String description = constructDescription(i);
            String salleReference = "salle" + (i % 30);
            String blocOperatoirReference = "bloc" + ((i % 10) + 1);
            String json = "{ " + reference + ", " + description + ", \"salle\": { \"reference\": \"" + salleReference + "\", \"blocOperatoir\": { \"reference\": \"" + blocOperatoirReference + "\" } } }";
            //res += "{ " + reference + ", " + description + " }";
            res += json;
            if (i < lastElement) {
                res += ",";
            }
        }
        String fileName = "";
        try {
            fileName = "data-" + lastElement + ".json";
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("[\n" + res + "]");
            bufferedWriter.close();
            System.out.println("Data saved successfully to " + fileName + " file.");
        } catch (IOException e) {
            System.out.println("Error while saving data to " + fileName + " file.");
            e.printStackTrace();
        }
        return res;
    }

    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return 10L * i;
    }

    private static Integer fakeInteger(String attributeName, int i) {
        return 10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return BigDecimal.valueOf(i * 1L * 10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }

    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }

    private static void addPermissionForAdmin(List<Permission> permissions) {
        permissions.add(new Permission("EvenementState.edit"));
        permissions.add(new Permission("EvenementState.list"));
        permissions.add(new Permission("EvenementState.view"));
        permissions.add(new Permission("EvenementState.add"));
        permissions.add(new Permission("EvenementState.delete"));
        permissions.add(new Permission("Evenement.edit"));
        permissions.add(new Permission("Evenement.list"));
        permissions.add(new Permission("Evenement.view"));
        permissions.add(new Permission("Evenement.add"));
        permissions.add(new Permission("Evenement.delete"));
        permissions.add(new Permission("Salle.edit"));
        permissions.add(new Permission("Salle.list"));
        permissions.add(new Permission("Salle.view"));
        permissions.add(new Permission("Salle.add"));
        permissions.add(new Permission("Salle.delete"));
        permissions.add(new Permission("BlocOperatoir.edit"));
        permissions.add(new Permission("BlocOperatoir.list"));
        permissions.add(new Permission("BlocOperatoir.view"));
        permissions.add(new Permission("BlocOperatoir.add"));
        permissions.add(new Permission("BlocOperatoir.delete"));
    }

    @Autowired
    EvenementStateAdminService evenementStateService;
    @Autowired
    SalleAdminService salleService;
    @Autowired
    BlocOperatoirAdminService blocOperatoirService;
}


