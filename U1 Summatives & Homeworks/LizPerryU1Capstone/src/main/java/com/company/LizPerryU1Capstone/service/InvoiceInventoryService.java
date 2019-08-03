package com.company.LizPerryU1Capstone.service;

import com.company.LizPerryU1Capstone.dao.*;
import com.company.LizPerryU1Capstone.model.*;
import com.company.LizPerryU1Capstone.viewmodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

// All the business rules
@Component
public class InvoiceInventoryService {

    // REST properly handles and reports all violations of business rules (jsr303?)
    private ConsoleDao consoleDao;
    private GameDao gameDao;
    private InvoiceDao invoiceDao;
    private ProcessingFeeDao processingFeeDao;
    private SalesTaxRateDao salesTaxRateDao;
    private TShirtDao tShirtDao;

    @Autowired
    //Be sure to add invoice, sales tax and processing fee back below this line!
    public InvoiceInventoryService(ConsoleDao consoleDao, GameDao gameDao, TShirtDao tShirtDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
        this.tShirtDao = tShirtDao;
    }

    // Console methods
    public ConsoleViewModel saveConsole(ConsoleViewModel consoleViewModel) {

        Console console = new Console();
        console.setModel(consoleViewModel.getModel());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());

        console = consoleDao.addConsole(console);

        consoleViewModel.setId(console.getId());

        return consoleViewModel;
    }

    public List<ConsoleViewModel> findAllConsoles() {
        List<Console> cList = consoleDao.getAllConsoles();

        List<ConsoleViewModel> consoleViewModelList = new ArrayList<>();
        for (Console console: cList) {
            ConsoleViewModel consoleViewModel = new ConsoleViewModel();
            consoleViewModel.setId(console.getId());
            consoleViewModel.setModel(console.getModel());
            consoleViewModel.setManufacturer(console.getManufacturer());
            consoleViewModel.setMemoryAmount(console.getMemoryAmount());
            consoleViewModel.setProcessor(console.getProcessor());
            consoleViewModel.setPrice(console.getPrice());
            consoleViewModel.setQuantity(console.getQuantity());

            consoleViewModelList.add(consoleViewModel);

        }

        return consoleViewModelList;

    }

    public ConsoleViewModel findConsole(int id) {

        Console console = consoleDao.getConsole(id);
        if (console != null) {

            ConsoleViewModel consoleViewModel = new ConsoleViewModel();
            consoleViewModel.setId(console.getId());
            consoleViewModel.setModel(console.getModel());
            consoleViewModel.setManufacturer(console.getManufacturer());
            consoleViewModel.setMemoryAmount(console.getMemoryAmount());
            consoleViewModel.setProcessor(console.getProcessor());
            consoleViewModel.setPrice(console.getPrice());
            consoleViewModel.setQuantity(console.getQuantity());

            return buildConsoleViewModel(console);

        } else {

            return null;

        }
    }

    public void removeConsole(int id) {

        consoleDao.deleteConsole(id);
    }

    public void updateConsole(ConsoleViewModel consoleViewModel) {

        Console console = new Console();
        console.setId(consoleViewModel.getId());
        console.setManufacturer(consoleViewModel.getManufacturer());
        console.setMemoryAmount(consoleViewModel.getMemoryAmount());
        console.setProcessor(consoleViewModel.getProcessor());
        console.setPrice(consoleViewModel.getPrice());
        console.setQuantity(consoleViewModel.getQuantity());
        consoleDao.updateConsole(console);

    }

    public List<ConsoleViewModel> findConsoleByManufacturer(String manufacturer) {
        List<Console> consoles = consoleDao.getConsoleByManufacturer(manufacturer);
        List<ConsoleViewModel> consoleViewModels = new ArrayList<>();

        for (Console console : consoles) {
            consoleViewModels.add(buildConsoleViewModel(console));
        }
        return consoleViewModels;
    }



    // Game methods
    public GameViewModel saveGame(GameViewModel gameViewModel) {

        Game game = new Game();
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());
        game = gameDao.addGame(game);

        gameViewModel.setId(game.getId());
        return gameViewModel;
    }

    public GameViewModel findGame(int id) {

        Game game = gameDao.getGame(id);
        if (game != null) {

            GameViewModel gameViewModel = new GameViewModel();
            gameViewModel.setId(game.getId());
            gameViewModel.setTitle(game.getTitle());
            gameViewModel.setEsrbRating(game.getEsrbRating());
            gameViewModel.setDescription(game.getDescription());
            gameViewModel.setPrice(game.getPrice());
            gameViewModel.setStudio(game.getStudio());
            gameViewModel.setQuantity(game.getQuantity());

            return buildGameViewModel(game);

        } else {

            return null;

        }
    }

    public List<GameViewModel> findAllGames() {
        List<Game> gameList = gameDao.getAllGames();

        List<GameViewModel> gameViewModelList = new ArrayList<>();
        for (Game game : gameList) {
            GameViewModel gameViewModel = new GameViewModel();
            gameViewModel.setId(game.getId());
            gameViewModel.setTitle(game.getTitle());
            gameViewModel.setEsrbRating(game.getEsrbRating());
            gameViewModel.setDescription(game.getDescription());
            gameViewModel.setPrice(game.getPrice());
            gameViewModel.setStudio(game.getStudio());
            gameViewModel.setQuantity(game.getQuantity());

            gameViewModelList.add(gameViewModel);
        }

        return gameViewModelList;
    }

    public void removeGame(int id) {

        gameDao.deleteGame(id);
    }

    public void updateGame(GameViewModel gameViewModel) {

        Game game = new Game();
        game.setId(gameViewModel.getId());
        game.setTitle(gameViewModel.getTitle());
        game.setEsrbRating(gameViewModel.getEsrbRating());
        game.setDescription(gameViewModel.getDescription());
        game.setPrice(gameViewModel.getPrice());
        game.setStudio(gameViewModel.getStudio());
        game.setQuantity(gameViewModel.getQuantity());
        gameDao.updateGame(game);

        //Do I need to build game view model here?
    }

    public List<GameViewModel> findGameByStudio(String studio) {
        List<Game> games = gameDao.getGamesByStudio(studio);
        List<GameViewModel> gameViewModels = new ArrayList<>();

        for (Game game : games) {
            gameViewModels.add(buildGameViewModel(game));
        }
        return gameViewModels;
    }

    public List<GameViewModel> findGamesByESRBRating(String esrbRating) {
        List<Game> games = gameDao.getGamesByESRB(esrbRating);
        List<GameViewModel> gameViewModels = new ArrayList<>();

        for (Game game : games) {
            gameViewModels.add(buildGameViewModel(game));
        }
        return gameViewModels;
    }

    public List<GameViewModel> findGamesByTitle(String title) {
        List<Game> games = gameDao.getGamesByTitle(title);
        List<GameViewModel> gameViewModels = new ArrayList<>();

        for (Game game : games) {
            gameViewModels.add(buildGameViewModel(game));
        }
        return gameViewModels;
    }



    // TShirt methods
    public TShirtViewModel saveTShirt(TShirtViewModel tShirtViewModel) {

        TShirt tShirt = new TShirt();
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());
        tShirt = tShirtDao.addTShirt(tShirt);

        tShirtViewModel.setId(tShirt.getId());
        return tShirtViewModel;

    }

    public TShirtViewModel findTShirt(int id) {

        TShirt tShirt = tShirtDao.getTShirt(id);
        if (tShirt != null) {

            TShirtViewModel tShirtViewModel = new TShirtViewModel();
            tShirtViewModel.setId(tShirt.getId());
            tShirtViewModel.setSize(tShirt.getSize());
            tShirtViewModel.setColor(tShirt.getColor());
            tShirtViewModel.setDescription(tShirt.getDescription());
            tShirtViewModel.setPrice(tShirt.getPrice());
            tShirtViewModel.setQuantity(tShirt.getQuantity());

//            return tShirtViewModel; which one of these is it?
            return buildTShirtViewModel(tShirt);

        } else {

            return null;

        }
    }

    public List<TShirtViewModel> findAllTShirts() {
        List<TShirt> tShirtList = tShirtDao.getAllTShirts();

        List<TShirtViewModel> tShirtViewModelList = new ArrayList<>();

        for (TShirt tShirt : tShirtList) {
            TShirtViewModel tShirtViewModel = new TShirtViewModel();
            tShirtViewModel.setId(tShirt.getId());
            tShirtViewModel.setSize(tShirt.getSize());
            tShirtViewModel.setColor(tShirt.getColor());
            tShirtViewModel.setDescription(tShirt.getDescription());
            tShirtViewModel.setPrice(tShirt.getPrice());
            tShirtViewModel.setQuantity(tShirt.getQuantity());
            tShirtViewModelList.add(tShirtViewModel);
        }
        return tShirtViewModelList;
    }

    public void removeTShirt(int id) {
        tShirtDao.deleteTShirt(id);
    }

    public void updateTShirt(TShirtViewModel tShirtViewModel) {

        TShirt tShirt = new TShirt();
        tShirt.setId(tShirtViewModel.getId());
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setQuantity(tShirtViewModel.getQuantity());
        tShirtDao.updateTShirt(tShirt);

        // AGAIN WITH THE BUILDING!
    }

    public List<TShirtViewModel> findTShirtByColor(String color) {
        List<TShirt> tShirts = tShirtDao.getTShirtsByColor(color);
        List<TShirtViewModel> tShirtViewModels = new ArrayList<>();

        for (TShirt tShirt : tShirts) {
            tShirtViewModels.add(buildTShirtViewModel(tShirt));
        }
        return tShirtViewModels;
    }

    public List<TShirtViewModel> findTShirtBySize(String size) {
        List<TShirt> tShirts = tShirtDao.getTShirtsBySize(size);
        List<TShirtViewModel> tShirtViewModels = new ArrayList<>();

        for (TShirt tShirt : tShirts) {
            tShirtViewModels.add(buildTShirtViewModel(tShirt));
        }
        return tShirtViewModels;
    }



    // ADDED MONDAY NIGHT:

    // INVOICE IS THE MOST IMPORTANT! HAS ALL THE BUSINESS RULES!

    //Invoice CRUDS

    // Save invoice needs to pull from PURCHASE! Save it, then calculate "business rules" side to add to invoice!
    @Transactional
    public InvoiceViewModel saveInvoice(PurchaseViewModel purchaseViewModel) throws InvalidInputException {

        String er = validatePurchase(purchaseViewModel);

        if (!er.equals("")) {

            throw new InvalidInputException(er);

        }

        Invoice invoice = new Invoice();
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();

        invoice.setName(purchaseViewModel.getName());
        invoice.setStreet(purchaseViewModel.getStreet());
        invoice.setCity(purchaseViewModel.getCity());
        invoice.setState(purchaseViewModel.getState());
        invoice.setZipCode(purchaseViewModel.getZipCode());
        invoice.setItemType(purchaseViewModel.getItemType());
        invoice.setItemId(purchaseViewModel.getItemId());
        invoice.setQuantity(purchaseViewModel.getQuantity());

        invoiceViewModel.setName(purchaseViewModel.getName());
        invoiceViewModel.setStreet(purchaseViewModel.getStreet());
        invoiceViewModel.setCity(purchaseViewModel.getCity());
        invoiceViewModel.setState(purchaseViewModel.getState());
        invoiceViewModel.setZipCode(purchaseViewModel.getZipCode());
        invoiceViewModel.setItemType(purchaseViewModel.getItemType());
        invoiceViewModel.setItemId(purchaseViewModel.getItemId());
        invoiceViewModel.setQuantity(purchaseViewModel.getQuantity());

        // Create your baby methods for business rules!
        // sales tax applies only to cost of items
        // grab state code from user input to determine tax, MUST BE VALID!
        // (sub total for items) * (state codes tax number = tax) = add to total (other things to compute)
        // no sales tax applied to processing fee
        // process fee only once per order per item (console, tshirt, game) unless > 10 then addition fee $15.49
        // update quantity properly (tshirt.setquantity = item quantity - customer purchase quantity)
        // order quantity > 0 but less than or equal to quantity on hand
        // have a common method where it calls the update method for all the objects

        //Unit price for the item type and id
        // Need to tweak this. Not calculating properly.
        BigDecimal unitPrice = getUnitPrice(purchaseViewModel.getItemType(), purchaseViewModel.getItemId());
        invoice.setUnitPrice(unitPrice);
        invoiceViewModel.setUnitPrice(unitPrice);

        //Subtotal for items
        BigDecimal subTotal = calculateSubTotal(invoiceViewModel.getUnitPrice(), invoiceViewModel.getQuantity());
        invoiceViewModel.setSubTotal(subTotal);
        invoice.setSubTotal(subTotal);

        // Set the tax by grabbing state
        BigDecimal taxRate = getTax(purchaseViewModel.getState());
        invoiceViewModel.setTax(taxRate);
        invoice.setTax(taxRate);

        // Get the processing fee by grabbing the itemType
        // Grab quantity if > 10
        BigDecimal processingFee = getProcessingFee(purchaseViewModel.getItemType(), invoiceViewModel.getQuantity());
        invoiceViewModel.setProcessingFee(processingFee);
        invoice.setProcessingFee(processingFee);

        // Total after all the outrageous fees
        BigDecimal total = calculateTotal(subTotal, taxRate, processingFee, invoiceViewModel.getQuantity());
        invoiceViewModel.setTotal(total);
        invoice.setTotal(total);

        invoice = invoiceDao.addInvoice(invoice);
        invoiceViewModel.setId(invoice.getId());

        updateQuantity(invoiceViewModel.getItemType(), invoiceViewModel.getItemId(), invoiceViewModel.getQuantity());
        return invoiceViewModel;
    }

    // Do I need this?????
    public List<InvoiceViewModel> getAllInvoices() {
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();

        List<InvoiceViewModel> invoiceViewModelList = new ArrayList<>();

        for (Invoice invoice : invoiceList) {
            InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
            invoiceViewModel.setId(invoice.getId());
            invoiceViewModel.setName(invoice.getName());
            invoiceViewModel.setStreet(invoice.getStreet());
            invoiceViewModel.setCity(invoice.getCity());
            invoiceViewModel.setState(invoice.getState());
            invoiceViewModel.setZipCode(invoice.getZipCode());
            invoiceViewModel.setItemType(invoice.getItemType());
            invoiceViewModel.setItemId(invoice.getItemId());
            invoiceViewModel.setQuantity(invoice.getQuantity());
            invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
            invoiceViewModel.setSubTotal(invoice.getSubTotal());
            invoiceViewModel.setTax(invoice.getTax());
            invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
            invoiceViewModel.setTotal(invoice.getTotal());

            invoiceViewModelList.add(invoiceViewModel);
        }
        return invoiceViewModelList;
    }

    public InvoiceViewModel findInvoice(int invoiceId) {
        Invoice invoice = invoiceDao.getInvoice(invoiceId);

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setId(invoice.getId());
        invoiceViewModel.setName(invoice.getName());
        invoiceViewModel.setStreet(invoice.getStreet());
        invoiceViewModel.setCity(invoice.getCity());
        invoiceViewModel.setState(invoice.getState());
        invoiceViewModel.setZipCode(invoice.getZipCode());
        invoiceViewModel.setItemType(invoice.getItemType());
        invoiceViewModel.setItemId(invoice.getItemId());
        invoiceViewModel.setQuantity(invoice.getQuantity());
        invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
        invoiceViewModel.setSubTotal(invoice.getSubTotal());
        invoiceViewModel.setTax(invoice.getTax());
        invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
        invoiceViewModel.setTotal(invoice.getTotal());

        return invoiceViewModel;
    }

    public void removeInvoice(int invoiceId) {
        invoiceDao.deleteInvoice(invoiceId);
    }



    // Validations Start here. There's A TON

    // methods of calculating extra parts for invoice (unit price, tax and processing fee)

    public BigDecimal getUnitPrice(String itemType, Integer itemId) {

        BigDecimal unitPrice = new BigDecimal("0.0");

        if (itemType.equals("console")) {

            Console console = consoleDao.getConsole(itemId);

            unitPrice = console.getPrice();

        } else if (itemType.equals("t_shirt")) {

            TShirt tShirt = tShirtDao.getTShirt(itemId);

            unitPrice = tShirt.getPrice();

        } else if (itemType.equals("game")) {

            Game game = gameDao.getGame(itemId);

            unitPrice = game.getPrice();

        }

        return unitPrice;

    }

    public BigDecimal getTax(String state) {

//        BigDecimal taxRate = new BigDecimal("0.0");

        SalesTaxRate salesTaxRate = salesTaxRateDao.getSalesTaxRateByState(state);

        BigDecimal taxRate = salesTaxRate.getRate();

        return taxRate;
    }

    public BigDecimal getProcessingFee(String itemType, Integer quantity) {

//        BigDecimal processFee = new BigDecimal("0.0");

        ProcessingFee processingFee = processingFeeDao.getProcessingFeeByProductType(itemType);

        BigDecimal processFee = processingFee.getFee();

        if (quantity > 10)

            processFee = processFee.add(new BigDecimal("15.49"));

        return processFee;

    }

    //calculate subTotal = unit price * quantity

    public BigDecimal calculateSubTotal(BigDecimal unitPrice, Integer quantity) {
        BigDecimal subTotal = new BigDecimal("0.0");

        subTotal = unitPrice.multiply(BigDecimal.valueOf(quantity));

        subTotal = subTotal.setScale(2, RoundingMode.HALF_UP);

        return subTotal;
    }

    // calculate total = (subtotal * taxrate) + processing fee

    public BigDecimal calculateTotal(BigDecimal subTotal, BigDecimal taxRate, BigDecimal processingFee, Integer quantity) {

        BigDecimal total = new BigDecimal("0.0");

        total = (subTotal.add(subTotal.multiply(taxRate))).add(processingFee);

        // Getting different totals, off by .01!
        //Used to round up
        total = total.setScale(2, RoundingMode.CEILING);

        return total;
    }

    // update quantity

    public void updateQuantity(String itemType, Integer itemId, Integer quantity) {

        if (itemType.equals("console")) {

            Console console = consoleDao.getConsole(itemId);

            console.setQuantity(console.getQuantity() - quantity);

            consoleDao.updateConsole(console);

        } else if (itemType.equals("t_shirt")) {

            TShirt tShirt = tShirtDao.getTShirt(itemId);

            tShirt.setQuantity(tShirt.getQuantity() - quantity);

            tShirtDao.updateTShirt(tShirt);

        } else if (itemType.equals("game")) {

            Game game = gameDao.getGame(itemId);

            game.setQuantity(game.getQuantity() - quantity);

            gameDao.updateGame(game);
        }
    }

   // validate that the purchase from user is correct and will pass business rules

    public String validatePurchase(PurchaseViewModel purchaseViewModel) {

        String er = "", itemError = "", onHandInventoryError = "";

        Integer isStocked = 0;
        String stateCode = purchaseViewModel.getState();
        String itemType = purchaseViewModel.getItemType();
        Integer itemId = purchaseViewModel.getItemId();
        Integer giveQuantity = purchaseViewModel.getQuantity();

        // Validate state code
        String stateCodeError = validateStateCode(stateCode);

        //Validate item type
        String itemTypeError = validateItemType(itemType);

        //Validate stock, quantity or if item does not exist
        String quantityErrorMessage = validateQuantity(giveQuantity);

        if (itemTypeError.length() == 0) {

            if (itemType.equals("console")) {

                Console console = consoleDao.getConsole(itemId);

                if (console == null) {

                    itemError = "This " + itemId + " does not exist. ";

                } else

                    isStocked = console.getQuantity();

            } else if (itemType.equals("t_shirt")) {

                TShirt tShirt = tShirtDao.getTShirt(itemId);

                if (tShirt == null) {

                    itemError = "This " + itemId + " does not exist. ";

                } else

                    isStocked = tShirt.getQuantity();

            } else if (itemType.equals("game")) {

                Game game = gameDao.getGame(itemId);

                if (game == null) {

                    itemError = "This " + itemId + " does not exist. ";

                } else

                    isStocked = game.getQuantity();

            }

            onHandInventoryError = validateQuantityOnHand(isStocked, giveQuantity);

        }

        er = stateCodeError + itemTypeError + quantityErrorMessage + itemError + onHandInventoryError;

        return er;
    }

   // validate that you can retrieve item type for processing fee

    public String validateItemType(String itemType) {
        String itemTypeErrorMessage = "";

        ProcessingFee processingFee = processingFeeDao.getProcessingFeeByProductType(itemType);

        if (processingFee == null) {

            // item does not exist
            itemTypeErrorMessage = "This itemType doesn't exist! ";

        }

        return itemTypeErrorMessage;
    }

    // validate that item is in stock from given quantity from user

    public String validateQuantityOnHand (int isStocked, int giveQuantity) {

        String onHandInventoryError = "";

        if (isStocked < giveQuantity)

            onHandInventoryError = "Not enough in stock! Please try again!";

        return onHandInventoryError;
    }

    // validate that the user ordered more than 0!

    public String validateQuantity(int giveQuantity) {

        String quantityErrorMessage = "";

        if (giveQuantity <= 0) {

            quantityErrorMessage = "Order quantity must be greater than 0!";

        }

        return quantityErrorMessage;
    }

    // validate that there is a state code!

    public String validateStateCode(String stateCode) {

        String stateCodeErrorMessage = "";

        SalesTaxRate salesTaxRate = salesTaxRateDao.getSalesTaxRateByState(stateCode);

        if (salesTaxRate == null)

            stateCodeErrorMessage = "Invalid State Code! ";

        return stateCodeErrorMessage;
    }

    // build methods

    private ConsoleViewModel buildConsoleViewModel(Console console) {

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setId(console.getId());
        consoleViewModel.setModel(console.getModel());
        consoleViewModel.setManufacturer(console.getManufacturer());
        consoleViewModel.setMemoryAmount(console.getMemoryAmount());
        consoleViewModel.setProcessor(console.getProcessor());
        consoleViewModel.setPrice(console.getPrice());
        consoleViewModel.setQuantity(console.getQuantity());

        return consoleViewModel;
    }

    private GameViewModel buildGameViewModel(Game game) {

        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setId(game.getId());
        gameViewModel.setTitle(game.getTitle());
        gameViewModel.setEsrbRating(game.getEsrbRating());
        gameViewModel.setDescription(game.getDescription());
        gameViewModel.setPrice(game.getPrice());
        gameViewModel.setStudio(game.getStudio());
        gameViewModel.setQuantity(game.getQuantity());
        return gameViewModel;
    }

    private TShirtViewModel buildTShirtViewModel(TShirt tShirt) {
        TShirtViewModel tShirtViewModel = new TShirtViewModel();
        tShirtViewModel.setId(tShirt.getId());
        tShirtViewModel.setColor(tShirt.getColor());
        tShirtViewModel.setSize(tShirt.getSize());
        tShirtViewModel.setDescription(tShirt.getDescription());
        tShirtViewModel.setPrice(tShirt.getPrice());
        tShirtViewModel.setQuantity(tShirt.getQuantity());
        return tShirtViewModel;
    }

    public class InvalidInputException extends Exception {
        public InvalidInputException(String errorMessage) {
            super(errorMessage);
        }
    }

//    private PurchaseViewModel buildPurchaseViewModel (Invoice invoice) {}

}
