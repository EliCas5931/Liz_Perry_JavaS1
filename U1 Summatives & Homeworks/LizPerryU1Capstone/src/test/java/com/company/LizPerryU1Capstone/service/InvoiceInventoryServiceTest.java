package com.company.LizPerryU1Capstone.service;

import com.company.LizPerryU1Capstone.dao.*;
import com.company.LizPerryU1Capstone.model.*;
import com.company.LizPerryU1Capstone.viewmodel.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class InvoiceInventoryServiceTest {

    private ConsoleDao consoleDao;
    private TShirtDao tShirtDao;
    private GameDao gameDao;
    private InvoiceDao invoiceDao;
    private ProcessingFeeDao processingFeeDao;
    private SalesTaxRateDao salesTaxRateDao;
    InvoiceInventoryService invoiceInventoryService;

    @Before
    public void setUp() throws Exception {

        setUpConsoleDaoMock();
        setUpTShirtDaoMock();
        setUpGameDaoMock();
        setUpInvoiceDaoMock();
        setUpProccessingFeeDaoMock();
        setUpSalesTaxRateDaoMock();

        invoiceInventoryService = new InvoiceInventoryService(consoleDao, gameDao, tShirtDao, invoiceDao, processingFeeDao,salesTaxRateDao);
    }

    private void setUpConsoleDaoMock() {

        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);

        Console console = new Console();
        console.setId(2);
        console.setModel("PlayStation 4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("500 GB");
        console.setProcessor("AMD Jaguar");
        console.setPrice(new BigDecimal("299.9").setScale(2));
        console.setQuantity(20);

        Console console2 = new Console();
        console2.setModel("PlayStation 4");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("500 GB");
        console2.setProcessor("AMD Jaguar");
        console2.setPrice(new BigDecimal("299.9").setScale(2));
        console2.setQuantity(20);

        List<Console> cList = new ArrayList<>();
        cList.add(console);

        doReturn(console).when(consoleDao).addConsole(console2);
        doReturn(console).when(consoleDao).getConsole(2);
        doReturn(cList).when(consoleDao).getAllConsoles();
        doReturn(cList).when(consoleDao).getConsoleByManufacturer("Sony");
    }

    private void setUpTShirtDaoMock() {

        tShirtDao = mock(TShirtDaoJdbcTemplateImpl.class);

        TShirt tShirt = new TShirt();
        tShirt.setId(5);
        tShirt.setSize("Medium");
        tShirt.setColor("Black");
        tShirt.setDescription("Overwatch Characters");
        tShirt.setPrice(new BigDecimal("14.99").setScale(2));
        tShirt.setQuantity(40);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("Medium");
        tShirt2.setColor("Black");
        tShirt2.setDescription("Overwatch Characters");
        tShirt2.setPrice(new BigDecimal("14.99").setScale(2));
        tShirt2.setQuantity(40);

        List<TShirt> tList = new ArrayList<>();
        tList.add(tShirt);

        doReturn(tShirt).when(tShirtDao).addTShirt(tShirt2);
        doReturn(tShirt).when(tShirtDao).getTShirt(5);
        doReturn(tList).when(tShirtDao).getAllTShirts();
        doReturn(tList).when(tShirtDao).getTShirtsByColor("Black");
        doReturn(tList).when(tShirtDao).getTShirtsBySize("Medium");
    }

    private void setUpGameDaoMock() {

        gameDao = mock(GamesDaoJdbcTemplateImpl.class);

        Game game = new Game();
        game.setId(45);
        game.setTitle("Overwatch");
        game.setEsrbRating("T");
        game.setDescription("Online multiplayer 6 v 6.");
        game.setPrice(new BigDecimal("29.99").setScale(2));
        game.setStudio("Blizzard");
        game.setQuantity(30);

        Game game2 = new Game();
        game2.setTitle("Overwatch");
        game2.setEsrbRating("T");
        game2.setDescription("Online multiplayer 6 v 6.");
        game2.setPrice(new BigDecimal("29.99").setScale(2));
        game2.setStudio("Blizzard");
        game2.setQuantity(30);

        List<Game> gList = new ArrayList<>();
        gList.add(game);

        doReturn(game).when(gameDao).addGame(game2);
        doReturn(game).when(gameDao).getGame(45);
        doReturn(gList).when(gameDao).getAllGames();
        doReturn(gList).when(gameDao).getGamesByESRB("T");
        doReturn(gList).when(gameDao).getGamesByTitle("Overwatch");
        doReturn(gList).when(gameDao).getGamesByStudio("Blizzard");
    }

    private void setUpInvoiceDaoMock() {

        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        Invoice invoice = new Invoice();
        invoice.setId(3);
        invoice.setName("Ana McCree");
        invoice.setStreet("200 Main Street");
        invoice.setCity("Charlotte");
        invoice.setState("SC");
        invoice.setZipCode("28056");
        invoice.setItemType("console");
        invoice.setItemId(2);
        invoice.setUnitPrice(new BigDecimal("299.99"));
        invoice.setQuantity(2);
        invoice.setSubTotal(new BigDecimal("599.98"));
        invoice.setTax(new BigDecimal(".05"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("650.97"));

        Invoice invoice2 = new Invoice();
        invoice.setName("Ashe McCree");
        invoice.setStreet("150 Main Street");
        invoice.setCity("Hickory");
        invoice.setState("SC");
        invoice.setZipCode("28050");
        invoice.setItemType("t_shirt");
        invoice.setItemId(2);
        invoice.setUnitPrice(new BigDecimal("29.99"));
        invoice.setQuantity(2);
        invoice.setSubTotal(new BigDecimal("59.98"));
        invoice.setTax(new BigDecimal(".06"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("65.56"));

        List<Invoice> iList = new ArrayList<>();
        iList.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice2);
        doReturn(invoice).when(invoiceDao).getInvoice(3);
        doReturn(iList).when(invoiceDao).getAllInvoices();
    }

    private void setUpProccessingFeeDaoMock() {

        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);

        ProcessingFee processingFeeConsoles = new ProcessingFee();
        processingFeeConsoles.setProductType("console");
        processingFeeConsoles.setFee(new BigDecimal("14.99"));

        ProcessingFee processingFeeTShirts = new ProcessingFee();
        processingFeeTShirts.setProductType("t_shirt");
        processingFeeTShirts.setFee(new BigDecimal("1.98"));

        ProcessingFee processingFeeGames = new ProcessingFee();
        processingFeeGames.setProductType("game");
        processingFeeGames.setFee(new BigDecimal("1.49"));

        doReturn(processingFeeGames).when(processingFeeDao).getProcessingFeeByProductType("game");
        doReturn(processingFeeTShirts).when(processingFeeDao).getProcessingFeeByProductType("t_shirt");
        doReturn(processingFeeConsoles).when(processingFeeDao).getProcessingFeeByProductType("console");
    }

    private void setUpSalesTaxRateDaoMock() {

        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);

        SalesTaxRate salesTaxRateSC = new SalesTaxRate();

        salesTaxRateSC.setState("SC");

        salesTaxRateSC.setRate(new BigDecimal(".06"));
        //doreturn here
        doReturn(salesTaxRateSC).when(salesTaxRateDao).getSalesTaxRateByState("SC");


    }


    // Console methods

    @Test
    public void saveConsole() {
        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setId(2);
        consoleViewModel.setModel("PlayStation 4");
        consoleViewModel.setManufacturer("Sony");
        consoleViewModel.setMemoryAmount("500 GB");
        consoleViewModel.setProcessor("AMD Jaguar");
        consoleViewModel.setPrice(new BigDecimal("299.9").setScale(2));
        consoleViewModel.setQuantity(20);

        consoleViewModel = invoiceInventoryService.saveConsole(consoleViewModel);

        ConsoleViewModel fromService = invoiceInventoryService.findConsole(consoleViewModel.getId());

        assertEquals(consoleViewModel, fromService);
    }

    @Test
    public void findAllConsoles() {
        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setId(2);
        consoleViewModel.setModel("PlayStation 4");
        consoleViewModel.setManufacturer("Sony");
        consoleViewModel.setMemoryAmount("500 GB");
        consoleViewModel.setProcessor("AMD Jaguar");
        consoleViewModel.setPrice(new BigDecimal("299.9").setScale(2));
        consoleViewModel.setQuantity(20);

        consoleViewModel = invoiceInventoryService.saveConsole(consoleViewModel);

        ConsoleViewModel fromService = invoiceInventoryService.findConsole(consoleViewModel.getId());

        assertEquals(consoleViewModel, fromService);

        List<ConsoleViewModel> cList = invoiceInventoryService.findAllConsoles();

        assertEquals(1, cList.size());
    }

    @Test
    public void findConsoleByManufacturer() {

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setId(2);
        consoleViewModel.setModel("PlayStation 4");
        consoleViewModel.setManufacturer("Sony");
        consoleViewModel.setMemoryAmount("500 GB");
        consoleViewModel.setProcessor("AMD Jaguar");
        consoleViewModel.setPrice(new BigDecimal("299.9").setScale(2));
        consoleViewModel.setQuantity(20);

        consoleViewModel = invoiceInventoryService.saveConsole(consoleViewModel);

        List<ConsoleViewModel> fromService = invoiceInventoryService.findConsoleByManufacturer("Sony");

        assertEquals(1, fromService.size());

        assertEquals(consoleViewModel, fromService.get(0));
    }

    // Game methods

    @Test
    public void saveGame() {
        GameViewModel gameViewModel = new GameViewModel();
        gameViewModel.setId(45);
        gameViewModel.setTitle("Overwatch");
        gameViewModel.setEsrbRating("T");
        gameViewModel.setDescription("Online multiplayer 6 v 6.");
        gameViewModel.setPrice(new BigDecimal("29.99").setScale(2));
        gameViewModel.setStudio("Blizzard");
        gameViewModel.setQuantity(30);

        gameViewModel = invoiceInventoryService.saveGame(gameViewModel);

        GameViewModel fromService = invoiceInventoryService.findGame(gameViewModel.getId());

        assertEquals(gameViewModel, fromService);
    }

    @Test
    public void findGame() {
        GameViewModel gameViewModel = new GameViewModel();

        gameViewModel.setTitle("Overwatch");
        gameViewModel.setEsrbRating("T");
        gameViewModel.setDescription("Online multiplayer 6 v 6.");
        gameViewModel.setPrice(new BigDecimal("29.99").setScale(2));
        gameViewModel.setStudio("Blizzard");
        gameViewModel.setQuantity(30);

        gameViewModel = invoiceInventoryService.saveGame(gameViewModel);

        GameViewModel fromService = invoiceInventoryService.findGame(gameViewModel.getId());

        assertEquals(gameViewModel, fromService);
    }

    @Test
    public void findAllGames() {
        GameViewModel gameViewModel = new GameViewModel();

        gameViewModel.setTitle("Overwatch");
        gameViewModel.setEsrbRating("T");
        gameViewModel.setDescription("Online multiplayer 6 v 6.");
        gameViewModel.setPrice(new BigDecimal("29.99").setScale(2));
        gameViewModel.setStudio("Blizzard");
        gameViewModel.setQuantity(30);

        gameViewModel = invoiceInventoryService.saveGame(gameViewModel);

        GameViewModel fromService = invoiceInventoryService.findGame(gameViewModel.getId());

        assertEquals(gameViewModel, fromService);

        List<GameViewModel> gameViewModelList = invoiceInventoryService.findAllGames();

        assertEquals(1, gameViewModelList.size());

        assertEquals(gameViewModel, gameViewModelList.get(0));
    }

    @Test
    public void findGamesByStudio() {
        GameViewModel gameViewModel = new GameViewModel();

        gameViewModel.setTitle("Overwatch");
        gameViewModel.setEsrbRating("T");
        gameViewModel.setDescription("Online multiplayer 6 v 6.");
        gameViewModel.setPrice(new BigDecimal("29.99").setScale(2));
        gameViewModel.setStudio("Blizzard");
        gameViewModel.setQuantity(30);

        gameViewModel = invoiceInventoryService.saveGame(gameViewModel);

        List<GameViewModel> fromService = invoiceInventoryService.findGameByStudio("Blizzard");

        assertEquals(1, fromService.size());

        assertEquals(gameViewModel, fromService.get(0));
    }

    @Test
    public void findGamesByESRBRating() {
        GameViewModel gameViewModel = new GameViewModel();

        gameViewModel.setTitle("Overwatch");
        gameViewModel.setEsrbRating("T");
        gameViewModel.setDescription("Online multiplayer 6 v 6.");
        gameViewModel.setPrice(new BigDecimal("29.99").setScale(2));
        gameViewModel.setStudio("Blizzard");
        gameViewModel.setQuantity(30);

        gameViewModel = invoiceInventoryService.saveGame(gameViewModel);

        List<GameViewModel> fromService = invoiceInventoryService.findGamesByESRBRating("T");

        assertEquals(1, fromService.size());

        assertEquals(gameViewModel, fromService.get(0));
    }

    @Test
    public void findGamesByTitle() {
        GameViewModel gameViewModel = new GameViewModel();

        gameViewModel.setTitle("Overwatch");
        gameViewModel.setEsrbRating("T");
        gameViewModel.setDescription("Online multiplayer 6 v 6.");
        gameViewModel.setPrice(new BigDecimal("29.99").setScale(2));
        gameViewModel.setStudio("Blizzard");
        gameViewModel.setQuantity(30);

        gameViewModel = invoiceInventoryService.saveGame(gameViewModel);

        List<GameViewModel> fromService = invoiceInventoryService.findGamesByTitle("Overwatch");

        assertEquals(1, fromService.size());

        assertEquals(gameViewModel, fromService.get(0));
    }

    // TShirt methods

    @Test
    public void saveTShirt() {
        TShirtViewModel tShirtViewModel = new TShirtViewModel();

        tShirtViewModel.setSize("Medium");
        tShirtViewModel.setColor("Black");
        tShirtViewModel.setDescription("Overwatch Characters");
        tShirtViewModel.setPrice(new BigDecimal("14.99").setScale(2));
        tShirtViewModel.setQuantity(40);

        tShirtViewModel = invoiceInventoryService.saveTShirt(tShirtViewModel);

        TShirtViewModel fromService = invoiceInventoryService.findTShirt(tShirtViewModel.getId());

        assertEquals(tShirtViewModel, fromService);
    }

    @Test
    public void findTShirt() {
        TShirtViewModel tShirtViewModel = new TShirtViewModel();

        tShirtViewModel.setSize("Medium");
        tShirtViewModel.setColor("Black");
        tShirtViewModel.setDescription("Overwatch Characters");
        tShirtViewModel.setPrice(new BigDecimal("14.99").setScale(2));
        tShirtViewModel.setQuantity(40);

        tShirtViewModel = invoiceInventoryService.saveTShirt(tShirtViewModel);

        TShirtViewModel fromService = invoiceInventoryService.findTShirt(tShirtViewModel.getId());

        assertEquals(tShirtViewModel, fromService);
    }

    @Test
    public void findAllTShirts() {
        TShirtViewModel tShirtViewModel = new TShirtViewModel();
        tShirtViewModel.setSize("Medium");
        tShirtViewModel.setColor("Black");
        tShirtViewModel.setDescription("Overwatch Characters");
        tShirtViewModel.setPrice(new BigDecimal("14.99").setScale(2));
        tShirtViewModel.setQuantity(40);

        tShirtViewModel = invoiceInventoryService.saveTShirt(tShirtViewModel);

        TShirtViewModel fromService = invoiceInventoryService.findTShirt(tShirtViewModel.getId());

        assertEquals(tShirtViewModel, fromService);

        List<TShirtViewModel> tShirtViewModels = invoiceInventoryService.findAllTShirts();

        assertEquals(1, tShirtViewModels.size());

        assertEquals(tShirtViewModel, tShirtViewModels.get(0));
    }

    @Test
    public void findTShirtByColor() {
        TShirtViewModel tShirtViewModel = new TShirtViewModel();
        tShirtViewModel.setSize("Medium");
        tShirtViewModel.setColor("Black");
        tShirtViewModel.setDescription("Overwatch Characters");
        tShirtViewModel.setPrice(new BigDecimal("14.99").setScale(2));
        tShirtViewModel.setQuantity(40);

        tShirtViewModel = invoiceInventoryService.saveTShirt(tShirtViewModel);

        List<TShirtViewModel> fromService = invoiceInventoryService.findTShirtByColor("Black");

        assertEquals(1, fromService.size());

        assertEquals(tShirtViewModel, fromService.get(0));
    }

    @Test
    public void findTShirtBySize() {
        TShirtViewModel tShirtViewModel = new TShirtViewModel();
        tShirtViewModel.setSize("Medium");
        tShirtViewModel.setColor("Black");
        tShirtViewModel.setDescription("Overwatch Characters");
        tShirtViewModel.setPrice(new BigDecimal("14.99").setScale(2));
        tShirtViewModel.setQuantity(40);

        tShirtViewModel = invoiceInventoryService.saveTShirt(tShirtViewModel);

        List<TShirtViewModel> fromService = invoiceInventoryService.findTShirtBySize("Medium");

        assertEquals(1, fromService.size());

        assertEquals(tShirtViewModel, fromService.get(0));
    }

    @Test
    public void validatePurchase() {

        PurchaseViewModel purchaseViewModel = new PurchaseViewModel();
        purchaseViewModel.setInvoiceId(5);
        purchaseViewModel.setName("Alston Goddfred");
        purchaseViewModel.setStreet("54 Elm Street");
        purchaseViewModel.setCity("Rock Hill");
        purchaseViewModel.setState("SC");
        purchaseViewModel.setZipCode("29710");
        purchaseViewModel.setItemType("console");
        purchaseViewModel.setItemId(1);
        purchaseViewModel.setQuantity(3);

        String er = invoiceInventoryService.validatePurchase(purchaseViewModel);
        assertEquals("This 1 does not exist. Not enough in stock! Please try again!", er);

        purchaseViewModel.setState("CS");
        er = invoiceInventoryService.validateStateCode(purchaseViewModel.getState());
        assertEquals("Invalid State Code! ", er);
        purchaseViewModel.setState("SC");

        purchaseViewModel.setItemType("tv");
        er = invoiceInventoryService.validateItemType(purchaseViewModel.getItemType());
        assertEquals("This itemType doesn't exist! ", er);
        purchaseViewModel.setItemType("console");

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setModel("PlayStation 4");
        consoleViewModel.setManufacturer("Sony");
        consoleViewModel.setMemoryAmount("500 GB");
        consoleViewModel.setProcessor("AMD Jaguar");
        consoleViewModel.setPrice(new BigDecimal("299.9").setScale(2));
        consoleViewModel.setQuantity(20);

        consoleViewModel = invoiceInventoryService.saveConsole(consoleViewModel);
        ConsoleViewModel fromService = invoiceInventoryService.findConsole(consoleViewModel.getId());
        assertEquals(consoleViewModel, fromService);

        purchaseViewModel.setItemId(2);
        assertEquals(purchaseViewModel.getItemId(), consoleViewModel.getId());

        purchaseViewModel.setQuantity(-10);
        er = invoiceInventoryService.validateQuantity(purchaseViewModel.getQuantity());
        assertEquals("Order quantity must be greater than 0!", er);
        purchaseViewModel.setQuantity(1);

        int isStocked = consoleViewModel.getQuantity();
        purchaseViewModel.setQuantity(1000);
        int giveQuantity = purchaseViewModel.getQuantity();
        er = invoiceInventoryService.validateQuantityOnHand(isStocked, giveQuantity);
        assertEquals("Not enough in stock! Please try again!", er);
        purchaseViewModel.setQuantity(1);
    }

    @Test
    public void updateQuantity() {

        Invoice invoice = new Invoice();
        invoice.setId(3);
        invoice.setName("Ana McCree");
        invoice.setStreet("200 Main Street");
        invoice.setCity("Charlotte");
        invoice.setState("SC");
        invoice.setZipCode("28056");
        invoice.setItemType("console");
        invoice.setItemId(2);
        invoice.setUnitPrice(new BigDecimal("299.99"));
        invoice.setQuantity(2);
        invoice.setSubTotal(new BigDecimal("599.98"));
        invoice.setTax(new BigDecimal(".05"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("644.97"));

        ConsoleViewModel consoleViewModel = new ConsoleViewModel();
        consoleViewModel.setId(2);
        consoleViewModel.setModel("PlayStation 4");
        consoleViewModel.setManufacturer("Sony");
        consoleViewModel.setMemoryAmount("500 GB");
        consoleViewModel.setProcessor("AMD Jaguar");
        consoleViewModel.setPrice(new BigDecimal("299.9").setScale(2));
        consoleViewModel.setQuantity(20);

        invoiceInventoryService.updateQuantity(invoice.getItemType(), invoice.getItemId(), invoice.getQuantity());

        assertEquals(18, consoleViewModel.getQuantity() - invoice.getQuantity());
    }

    @Test
    public void validateBusinessRules() {

        Invoice invoice = new Invoice();
        invoice.setId(3);
        invoice.setName("Ana McCree");
        invoice.setStreet("200 Main Street");
        invoice.setCity("Charlotte");
        invoice.setState("SC");
        invoice.setZipCode("28056");
        invoice.setItemType("console");
        invoice.setItemId(10);
        invoice.setUnitPrice(new BigDecimal("299.99"));
        invoice.setQuantity(2);
        invoice.setSubTotal(new BigDecimal("599.98"));
        invoice.setTax(new BigDecimal(".06"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("650.97"));

        BigDecimal subTotal = invoiceInventoryService.calculateSubTotal(invoice.getUnitPrice(), invoice.getQuantity());
        assertEquals(new BigDecimal("599.98"), subTotal);

        BigDecimal taxRate = invoiceInventoryService.getTax(invoice.getState());
        assertEquals(new BigDecimal(".06"), taxRate);

        BigDecimal processingFee = invoiceInventoryService.getProcessingFee(invoice.getItemType(), invoice.getQuantity());
        assertEquals(new BigDecimal("14.99"), processingFee);

        BigDecimal total = invoiceInventoryService.calculateTotal(invoice.getSubTotal(), invoice.getTax(), invoice.getProcessingFee(), invoice.getQuantity());
        assertEquals(new BigDecimal("650.97"), total);

    }

}
