package ma.sir.event.ws.facade.admin;


import com.corundumstudio.socketio.SocketIOServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.event.bean.core.BlocOperatoirMetaData;
import ma.sir.event.bean.core.Evenement;
import ma.sir.event.bean.core.EvenementRedis;
import ma.sir.event.bean.history.EvenementHistory;
import ma.sir.event.dao.criteria.core.EvenementCriteria;
import ma.sir.event.dao.criteria.history.EvenementHistoryCriteria;
import ma.sir.event.service.facade.admin.EvenementAdminService;
import ma.sir.event.service.facade.admin.SalleAdminService;
import ma.sir.event.service.impl.admin.BlocOperatoireInformation;
import ma.sir.event.service.impl.admin.EvenementAdminRedisServiceImpl;
import ma.sir.event.ws.converter.EvenementConverter;
import ma.sir.event.ws.dto.BlocOperatoirDto;
import ma.sir.event.ws.dto.BlocOperatoirMetaDataDto;
import ma.sir.event.ws.dto.EvenementDto;
import ma.sir.event.zynerator.controller.AbstractController;
import ma.sir.event.zynerator.dto.AuditEntityDto;
import ma.sir.event.zynerator.dto.FileTempDto;
import ma.sir.event.zynerator.util.DateUtil;
import ma.sir.event.zynerator.util.PaginatedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api("Manages evenement services")
@RestController
@RequestMapping("/api/admin/evenement/")
public class EvenementRestAdmin extends AbstractController<Evenement, EvenementDto, EvenementHistory, EvenementCriteria, EvenementHistoryCriteria, EvenementAdminService, EvenementConverter> {


    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all evenements")
    @GetMapping("")
    public ResponseEntity<List<EvenementDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all evenements")
    @GetMapping("optimized")
    public ResponseEntity<List<EvenementDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a evenement by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EvenementDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }


    @PostMapping("")
    public ResponseEntity<EvenementDto> save(@RequestBody EvenementDto dto) throws Exception {
        return super.save(dto);
    }


    @PutMapping("")
    public ResponseEntity<EvenementDto> update(@RequestBody EvenementDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of evenement")
    @PostMapping("multiple")
    public ResponseEntity<List<EvenementDto>> delete(@RequestBody List<EvenementDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }

    @ApiOperation("Delete the specified evenement")
    @DeleteMapping("")
    public ResponseEntity<EvenementDto> delete(@RequestBody EvenementDto dto) throws Exception {
        return super.delete(dto);
    }

    @ApiOperation("Delete the specified evenement")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }

    @ApiOperation("Delete multiple evenements by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        return super.deleteByIdIn(ids);
    }


    @ApiOperation("find by salle id")
    @GetMapping("salle/id/{id}")
    public List<Evenement> findBySalleId(@PathVariable Long id) {
        return service.findBySalleId(id);
    }

    @ApiOperation("find by bloc operatoir reference")
    @PostMapping("bloc-operatoir")
    public BlocOperatoireInformation findBySalleBlocOperatoirReference(@RequestBody BlocOperatoireInformation input) {
        long start = System.currentTimeMillis();
        BlocOperatoireInformation blocOperatoireInformation=service.findBySalleBlocOperatoirReference(input.getReference(), DateUtil.convert(input.getLastUpdate()));
        long end = System.currentTimeMillis();
        System.out.println("reference == "+input.getReference()+" , lastUpdate front ="+input.getLastUpdate()+" and duration = " + ((end - start))+" ms");
        return blocOperatoireInformation;
    }

    @ApiOperation("delete by salle id")
    @DeleteMapping("salle/id/{id}")
    public int deleteBySalleId(@PathVariable Long id) {
        return service.deleteBySalleId(id);
    }

    @ApiOperation("find by evenementState id")
    @GetMapping("evenementState/id/{id}")
    public List<Evenement> findByEvenementStateId(@PathVariable Long id) {
        return service.findByEvenementStateId(id);
    }

    @ApiOperation("delete by evenementState id")
    @DeleteMapping("evenementState/id/{id}")
    public int deleteByEvenementStateId(@PathVariable Long id) {
        return service.deleteByEvenementStateId(id);
    }

    @ApiOperation("Finds evenements by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EvenementDto>> findByCriteria(@RequestBody EvenementCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated evenements by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EvenementCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports evenements by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EvenementCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets evenement data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EvenementCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets evenement history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets evenement paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EvenementHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports evenement history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EvenementHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets evenement history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EvenementHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }

    public EvenementRestAdmin(EvenementAdminService service, EvenementConverter converter, SocketIOServer socketIOServer) {
        super(service, converter);
        this.socketIOServer = socketIOServer;
    }

    @Autowired
    EvenementAdminRedisServiceImpl evenementAdminRedisService;

    @Autowired
    SalleAdminService salleAdminService;

    @Autowired
    EvenementAdminService evenementAdminService;
    private final SocketIOServer socketIOServer;

}