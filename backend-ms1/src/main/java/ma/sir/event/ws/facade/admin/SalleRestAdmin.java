package  ma.sir.event.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.event.bean.core.Salle;
import ma.sir.event.bean.history.SalleHistory;
import ma.sir.event.dao.criteria.core.SalleCriteria;
import ma.sir.event.dao.criteria.history.SalleHistoryCriteria;
import ma.sir.event.service.facade.admin.SalleAdminService;
import ma.sir.event.ws.converter.SalleConverter;
import ma.sir.event.ws.dto.SalleDto;
import ma.sir.event.zynerator.controller.AbstractController;
import ma.sir.event.zynerator.dto.AuditEntityDto;
import ma.sir.event.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.event.zynerator.process.Result;

import org.springframework.web.multipart.MultipartFile;
import ma.sir.event.zynerator.dto.FileTempDto;

@Api("Manages salle services")
@RestController
@RequestMapping("/api/admin/salle/")
public class SalleRestAdmin  extends AbstractController<Salle, SalleDto, SalleHistory, SalleCriteria, SalleHistoryCriteria, SalleAdminService, SalleConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all salles")
    @GetMapping("")
    public ResponseEntity<List<SalleDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all salles")
    @GetMapping("optimized")
    public ResponseEntity<List<SalleDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a salle by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SalleDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  salle")
    @PostMapping("")
    public ResponseEntity<SalleDto> save(@RequestBody SalleDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  salle")
    @PutMapping("")
    public ResponseEntity<SalleDto> update(@RequestBody SalleDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of salle")
    @PostMapping("multiple")
    public ResponseEntity<List<SalleDto>> delete(@RequestBody List<SalleDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified salle")
    @DeleteMapping("")
    public ResponseEntity<SalleDto> delete(@RequestBody SalleDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified salle")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple salles by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by blocOperatoir id")
    @GetMapping("blocOperatoir/id/{id}")
    public List<Salle> findByBlocOperatoirId(@PathVariable Long id){
        return service.findByBlocOperatoirId(id);
    }
    @ApiOperation("delete by blocOperatoir id")
    @DeleteMapping("blocOperatoir/id/{id}")
    public int deleteByBlocOperatoirId(@PathVariable Long id){
        return service.deleteByBlocOperatoirId(id);
    }
    @ApiOperation("Finds salles by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SalleDto>> findByCriteria(@RequestBody SalleCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated salles by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SalleCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports salles by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SalleCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets salle data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SalleCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets salle history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets salle paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SalleHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports salle history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SalleHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets salle history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SalleHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SalleRestAdmin (SalleAdminService service, SalleConverter converter) {
        super(service, converter);
    }


}