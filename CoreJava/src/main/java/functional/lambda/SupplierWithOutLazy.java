package functional.lambda;

import java.util.Optional;

public class SupplierWithOutLazy {

    static String getDefaultConfig() {
        System.out.println("Loading default config");
        return "DEFAULT_CONFIG";
    }

    public static void main(String[] args) {
        String config = null;
        //Default is computed, whether needed or not
        String final_config = config != null ? config : getDefaultConfig();
        System.out.println("Final Config 1 " + final_config);

        String config2 = "Lazy";
        String final_config2 = null;
        final_config2 = Optional.ofNullable(config2)
                .orElse(getDefaultConfig());
        System.out.println("Final Config 2 " + final_config2);

        String config3 = "hello "; //null
        String final_config3 = null;
        final_config3 = Optional.ofNullable(config3).orElseGet(() -> getDefaultConfig()); // Lazy .. getDefaultConfig -> only if config3 is null
        System.out.println("Final Config 3 " + final_config3);

/*Supplier<String> fallbackMessage = () -> restTemplate.getForObject("http://slow-fallback-api/message", String.class);

String message = Optional.ofNullable(primaryMessage).orElseGet(fallbackMessage);
*/
    }
// ✅ The fallback API is only called if primaryMessage is null — very efficient.
}
