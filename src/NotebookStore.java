import java.util.*;

public class NotebookStore {
    private Set<Notebook> notebooks;

    public NotebookStore() {
        notebooks = new HashSet<>();
    }

    // Метод для добавления ноутбука в множество
    public void addNotebook(Notebook notebook) {
        notebooks.add(notebook);
    }

    // Метод для фильтрации ноутбуков
    public Set<Notebook> filterNotebooks(Map<String, String> criteria) {
        Set<Notebook> filteredNotebooks = new HashSet<>(notebooks);

        for (Map.Entry<String, String> entry : criteria.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            switch (key) {
                case "ram":
                    int minRam = Integer.parseInt(value);
                    filteredNotebooks.removeIf(notebook -> notebook.getRam() < minRam);
                    break;
                case "hdd":
                    int minHdd = Integer.parseInt(value);
                    filteredNotebooks.removeIf(notebook -> notebook.getHdd() < minHdd);
                    break;
                case "os":
                    filteredNotebooks.removeIf(notebook -> !notebook.getOs().equalsIgnoreCase(value));
                    break;
                case "color":
                    filteredNotebooks.removeIf(notebook -> !notebook.getColor().equalsIgnoreCase(value));
                    break;
            }
        }

        return filteredNotebooks;
    }

    // Метод для запроса критериев фильтрации у пользователя
    public static Map<String, String> getUserCriteria() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> criteria = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criterion = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (criterion) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ (ГБ):");
                criteria.put("ram", scanner.nextLine());
                break;
            case 2:
                System.out.println("Введите минимальное значение объема ЖД (ГБ):");
                criteria.put("hdd", scanner.nextLine());
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                criteria.put("os", scanner.nextLine());
                break;
            case 4:
                System.out.println("Введите цвет:");
                criteria.put("color", scanner.nextLine());
                break;
        }

        return criteria;
    }

    public static void main(String[] args) {
        NotebookStore store = new NotebookStore();

        // Добавление ноутбуков
        store.addNotebook(new Notebook("Dell", 8, 512, "Windows", "Black"));
        store.addNotebook(new Notebook("HP", 16, 1024, "Windows", "Silver"));
        store.addNotebook(new Notebook("Apple", 8, 256, "MacOS", "Gray"));
        store.addNotebook(new Notebook("Asus", 16, 512, "Linux", "Black"));

        // Запрос критериев у пользователя
        Map<String, String> criteria = getUserCriteria();

        // Фильтрация ноутбуков и вывод результата
        Set<Notebook> filteredNotebooks = store.filterNotebooks(criteria);
        filteredNotebooks.forEach(System.out::println);
    }
}
