package  ma.sir.event.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.event.bean.core.BlocOperatoir;
import ma.sir.event.bean.history.BlocOperatoirHistory;
import ma.sir.event.dao.criteria.core.BlocOperatoirCriteria;
import ma.sir.event.dao.criteria.history.BlocOperatoirHistoryCriteria;
import ma.sir.event.service.facade.admin.BlocOperatoirAdminService;
import ma.sir.event.ws.converter.BlocOperatoirConverter;
import ma.sir.event.ws.dto.BlocOperatoirDto;
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

@Api("Manages blocOperatoir services")
@RestController
@RequestMapping("/api/admin/blocOperatoir/")
public class BlocOperatoirRestAdmin  extends AbstractController<BlocOperatoir, BlocOperatoirDto, BlocOperatoirHistory, BlocOperatoirCriteria, BlocOperatoirHistoryCriteria, BlocOperatoirAdminService, BlocOperatoirConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all blocOperatoirs")
    @GetMapping("")
    public ResponseEntity<List<BlocOperatoirDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all blocOperatoirs")
    @GetMapping("optimized")
    public ResponseEntity<List<BlocOperatoirDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a blocOperatoir by id")
    @GetMapping("id/{id}")
    public ResponseEntity<BlocOperatoirDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  blocOperatoir")
    @PostMapping("")
    public ResponseEntity<BlocOperatoirDto> save(@RequestBody BlocOperatoirDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  blocOperatoir")
    @PutMapping("")
    public ResponseEntity<BlocOperatoirDto> update(@RequestBody BlocOperatoirDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of blocOperatoir")
    @PostMapping("multiple")
    public ResponseEntity<List<BlocOperatoirDto>> delete(@RequestBody List<BlocOperatoirDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified blocOperatoir")
    @DeleteMapping("")
    public ResponseEntity<BlocOperatoirDto> delete(@RequestBody BlocOperatoirDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified blocOperatoir")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple blocOperatoirs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds blocOperatoirs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<BlocOperatoirDto>> findByCriteria(@RequestBody BlocOperatoirCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated blocOperatoirs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody BlocOperatoirCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports blocOperatoirs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody BlocOperatoirCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets blocOperatoir data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody BlocOperatoirCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets blocOperatoir history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets blocOperatoir paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody BlocOperatoirHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports blocOperatoir history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody BlocOperatoirHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets blocOperatoir history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody BlocOperatoirHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public BlocOperatoirRestAdmin (BlocOperatoirAdminService service, BlocOperatoirConverter converter) {
        super(service, converter);
    }


}