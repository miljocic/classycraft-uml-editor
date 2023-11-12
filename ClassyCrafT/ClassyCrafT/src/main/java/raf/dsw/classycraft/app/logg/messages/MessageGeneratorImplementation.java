package raf.dsw.classycraft.app.logg.messages;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class MessageGeneratorImplementation implements MessageGenerator{

    private Message message;
    private List<ISubscriber> subslist = new ArrayList<>(); //lista za cuvanje subscribera
    @Override
    public void generateMessage(ErrorType errorType) {

        if (ErrorType.ERROR.equals(errorType)) {
            createMessage("Greska: ", errorType);
        } else if (ErrorType.CANNOT_DELETE_PROJECT_EXPLORER.equals(errorType)) {
            createMessage("Ne moze da se obrise Project Explorer!", errorType);
        } else if (ErrorType.CANNOT_ADD_CHILD.equals(errorType)) {
            createMessage("Na dijagram se ne moze dalje dodavati", errorType);
        } else if (ErrorType.NODE_NOT_CREATED.equals(errorType)) {
            createMessage("Komponenta nije kreirana", errorType);
        } else if (ErrorType.NODE_ALREADY_EXISTS.equals(errorType)) {
            createMessage("Ova komponenta vec postoji!", errorType);
        } else if (ErrorType.NODE_NOT_SELECTED.equals(errorType)) {
            createMessage("Nije selektovana nijedna komponenta!", errorType);
        } else if (ErrorType.NODE_CANNOT_BE_RENAMED.equals(errorType)) {
            createMessage("Ova komponenta ne moze da se preimenuje!", errorType);
        } else if(ErrorType.PROJECT_NOT_SELECTED.equals(errorType)) {
            createMessage("Nije selektovan Projekat!", errorType);
        } else if (ErrorType.NAME_CANNOT_BE_EMPTY.equals(errorType)) {
            createMessage("Ime ne moze biti prazno!", errorType);
        } else if (ErrorType.CANNOT_DELETE_FILE.equals(errorType)) {
            createMessage("Ovaj fajl ne moze da se obrise", errorType);
        } else if (ErrorType.RESOURCE_NOT_FOUND.equals(errorType)) {
            createMessage("Ne postoji putanja!", errorType);
        } else if (ErrorType.SAVE_ERROR.equals(errorType)) {
            createMessage("Greska pri cuvanju podataka", errorType);
        }

    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if (sub != null && !subslist.contains(sub)) {
            subslist.add(sub);
        }

    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subslist.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        for (ISubscriber sub : subslist) {
            sub.update(notification);
        }
    }

    @Override
    public void notifySubscriber(Object notification) {

    }

    private void createMessage(String tekst, ErrorType errorType) {
        this.message = new Message(tekst, errorType);
        notifySubscribers(this.message);
    }
}
