package  ma.sir.event.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.event.bean.core.EvenementState;
import ma.sir.event.bean.history.EvenementStateHistory;
import ma.sir.event.dao.criteria.core.EvenementStateCriteria;
import ma.sir.event.dao.criteria.history.EvenementStateHistoryCriteria;
import ma.sir.event.service.facade.admin.EvenementStateAdminService;
import ma.sir.event.ws.converter.EvenementStateConverter;
import ma.sir.event.ws.dto.EvenementStateDto;
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

@Api("Manages evenementState services")
@RestController
@RequestMapping("/api/admin/evenementState/")
public class EvenementStateRestAdmin  extends AbstractController<EvenementState, EvenementStateDto, EvenementStateHistory, EvenementStateCriteria, EvenementStateHistoryCriteria, EvenementStateAdminService, EvenementStateConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all evenementStates")
    @GetMapping("")
    public ResponseEntity<List<EvenementStateDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all evenementStates")
    @GetMapping("optimized")
    public ResponseEntity<List<EvenementStateDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a evenementState by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EvenementStateDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  evenementState")
    @PostMapping("")
    public ResponseEntity<EvenementStateDto> save(@RequestBody EvenementStateDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  evenementState")
    @PutMapping("")
    public ResponseEntity<EvenementStateDto> update(@RequestBody EvenementStateDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of evenementState")
    @PostMapping("multiple")
    public ResponseEntity<List<EvenementStateDto>> delete(@RequestBody List<EvenementStateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified evenementState")
    @DeleteMapping("")
    public ResponseEntity<EvenementStateDto> delete(@RequestBody EvenementStateDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified evenementState")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple evenementStates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds evenementStates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EvenementStateDto>> findByCriteria(@RequestBody EvenementStateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated evenementStates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EvenementStateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports evenementStates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EvenementStateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets evenementState data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EvenementStateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets evenementState history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets evenementState paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody EvenementStateHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports evenementState history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody EvenementStateHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets evenementState history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody EvenementStateHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public EvenementStateRestAdmin (EvenementStateAdminService service, EvenementStateConverter converter) {
        super(service, converter);
    }


}