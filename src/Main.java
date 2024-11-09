import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        HotelFacade hotelFacade = new HotelFacade();
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = startDate.plusDays(3);

        // Вызов фасада для бронирования номера с необходимыми услугами
        hotelFacade.bookRoom(startDate, endDate, 3);

        // Организация мероприятия с бронированием помещений и заказом оборудования
        hotelFacade.organizeEvent("Конференция", 100);
    }
}

class HotelFacade {
    private RoomBookingSystem roomBookingSystem;
    private CleaningService cleaningService;
    private RestaurantService restaurantService;
    private EventManagementSystem eventManagementSystem;

    public HotelFacade() {
        roomBookingSystem = new RoomBookingSystem();
        cleaningService = new CleaningService();
        restaurantService = new RestaurantService();
        eventManagementSystem = new EventManagementSystem();
    }

    // Фасадный метод для бронирования номера и организации дополнительных услуг
    public void bookRoom(LocalDateTime startDate, LocalDateTime endDate, int peopleAmount) {
        roomBookingSystem.makeReservation(startDate, endDate, peopleAmount);
        roomBookingSystem.payment(500); // Примерная сумма оплаты

        cleaningService.notify(startDate, endDate, peopleAmount);
        restaurantService.notify(peopleAmount, 200); // Сервировка столов для гостей
    }

    // Фасад для организации корпоративного мероприятия
    public void organizeEvent(String eventName, int participants) {
        eventManagementSystem.organizeEvent(eventName, participants);
        eventManagementSystem.orderEquipment("Проектор");
        roomBookingSystem.makeReservation(LocalDateTime.now(), LocalDateTime.now().plusDays(1), participants);
    }
}

class RoomBookingSystem {
    // Метод для бронирования номера на заданные даты
    public void makeReservation(LocalDateTime startTime, LocalDateTime endTime, int peopleAmount) {
        System.out.println("Забронирован номер с " + startTime + " по " + endTime + " для " + peopleAmount + " человек.");
    }

    // Метод для выполнения оплаты за услуги
    public void payment(double pay) {
        System.out.println("Осуществлена оплата на сумму: " + pay + " рублей.");
    }
}

class RestaurantService {
    // Уведомление ресторана о заказе стола и количестве гостей
    public void notify(int roomNum, int peopleAmount) {
        System.out.println("Резервирование стола для " + peopleAmount + " человек в ресторане.");
    }
}

class EventManagementSystem {
    // Организация мероприятия и расчет количества участников
    public void organizeEvent(String eventName, int participants) {
        System.out.println("Организация события: " + eventName + " для " + participants + " человек.");
    }

    // Заказ необходимого оборудования для мероприятия
    public void orderEquipment(String equipment) {
        System.out.println("Заказ оборудования: " + equipment);
    }
}

class CleaningService {
    // Оповещение службы уборки о необходимости уборки номеров
    public void notify(LocalDateTime startDate, LocalDateTime endDate, int roomNum) {
        System.out.println("Запланирована уборка номера с " + startDate + " по " + endDate + " для номера: " + roomNum);
    }
}
