package student;

import common.RegistrationServiceInterface;

public class RegistrationServiceProxy implements RegistrationServiceInterface {

    private final RegistrationServiceInterface service;

    public RegistrationServiceProxy(RegistrationServiceInterface service) {
        this.service = service;
    }


    @Override
    public void showMenu() {
        System.out.println("Salam Aleykum");
        service.showMenu();
        System.out.println("Menu bitdi");
    }

    @Override
    public void register() {
        service.register();
    }

    @Override
    public void showAll() {
        service.showAll();
    }

    @Override
    public void update() {
        service.update();
    }

    @Override
    public void delete() {
        service.delete();
    }
}
